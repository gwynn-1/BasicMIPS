package Datapath;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

import javax.swing.Timer;

public abstract class ModelDrawing extends JPanel {
	
	//define diem di chuyen de ve line
	protected int xdyn=0;
	protected int ydyn=0;
	//define timer
	static Timer timer;
	static int delay=10;
        static boolean isBack = false;
        static boolean isForward =false;
        static boolean isClear = false;
        
        //define Setup
        static RenderingHints renderhints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        static LineColor colorCrit = LineColor.Default;
        static LineColor colorIns= LineColor.Default;
        static LineColor colorUni= LineColor.Default;
        static float thickness=3.5f;
        
        //define thanh phan MIPS
        protected String opcode= "";
        protected String RS="";
        protected String RT="";
        protected String RD="";
        protected String shamt="";
        protected String funct="";
        
        public int arrayLength;
	
	protected int lineNumber=0;
        protected boolean isDone = false;
        
        private BufferedImage imgPC = null;
        private BufferedImage imgInsMem =null;
        private BufferedImage imgReg = null;
        private BufferedImage imgALU = null;
        private BufferedImage imgDataMem =null;
        private BufferedImage imgControl =null;
        private BufferedImage imgMUX1 = null;
        private BufferedImage imgMUX2 = null;
        private BufferedImage imgSignex = null;
        private BufferedImage imgSLL = null;
        private BufferedImage imgALUCtrl = null;
        
        public ModelDrawing()
        {
            try {
            InputStream streamPC = getClass().getResourceAsStream("/PC.png");
            imgPC =ImageIO.read(streamPC);
           
            InputStream streamInsMem = getClass().getResourceAsStream("/InsMem.png");
            imgInsMem = ImageIO.read(streamInsMem);
            
            InputStream streamReg = getClass().getResourceAsStream("/Register.png");
            imgReg = ImageIO.read(streamReg);
            
            InputStream streamALU = getClass().getResourceAsStream("/ALU.png");
            imgALU = ImageIO.read(streamALU);
            
            InputStream streamDataMem = getClass().getResourceAsStream("/DataMem.png");
            imgDataMem = ImageIO.read(streamDataMem);
            
            InputStream streamControl = getClass().getResourceAsStream("/Control.png");
            imgControl = ImageIO.read(streamControl);
            
            InputStream streamMUX1 = getClass().getResourceAsStream("/MUX1.png");
            imgMUX1 = ImageIO.read(streamMUX1);
            
            InputStream streamMUX2 = getClass().getResourceAsStream("/MUX2.png");
            imgMUX2 = ImageIO.read(streamMUX2); 
            
            InputStream streamSignex = getClass().getResourceAsStream("/Sign-Extend.png");
            imgSignex = ImageIO.read(streamSignex);
            
            InputStream streamSLL = getClass().getResourceAsStream("/sll2.png");
            imgSLL = ImageIO.read(streamSLL);
            
            InputStream streamALUCtrl = getClass().getResourceAsStream("/ALUControl.png");
            imgALUCtrl = ImageIO.read(streamALUCtrl);
             } catch (IOException ex) {
                Logger.getLogger(ModelDrawing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	
	protected void Calculate(int X1, int Y1, int X2, int Y2)
	{
		if(xdyn == 0 && ydyn == 0)
		{	
			xdyn = X1;
			ydyn = Y1;
		}
		if(( X1<X2 && xdyn<X2)||(X1>X2 && xdyn>X2)||(Y1<Y2 && ydyn <Y2)||(Y1>=Y2&&ydyn>Y2))
			{	
				int Xvector= Y2-Y1;
				int Yvector = -(X2-X1);
				if(X1 != X2)
				{
					if(X2>X1)
						xdyn += 2;
					else if (X2<X1)
						xdyn -= 2;
					if(Y1!=Y2)
						ydyn = Math.abs((Xvector*X1+Yvector*Y1-Xvector*xdyn)/(Yvector));
					else 
						ydyn = Y1;
				}
				else
				{
					if(Y1<Y2)
						ydyn += 2;
					if(Y1>=Y2)
						ydyn -= 2;
				}
				isDone = false;
                                repaint();
			}
		if(X2 == xdyn && Y2 == ydyn)
		{
			isDone = true;
		}
		else if((X2 == xdyn -1 && Y2 == ydyn -1) || (X2 == xdyn &&Y2==ydyn-1)||(X2==xdyn-1&& Y2==ydyn))
		{
			isDone = true;
		}
		else if((X2 == xdyn +1 && Y2 == ydyn +1)|| (X2 == xdyn &&Y2==ydyn+1)||(X2==xdyn+1&& Y2==ydyn))
		{
			isDone = true;
		}
	}
	
        protected Paint getCritColor()
        {
             switch (colorCrit)
             {
                 case Black: return Color.BLACK;
                 case Blue:return Color.BLUE;
                 case Cyan:return Color.CYAN;
                 case Green:return Color.GREEN;
                 case Gray:return Color.GRAY;
                 case DarkGray:return Color.DARK_GRAY;
                 case LightGray:return Color.LIGHT_GRAY;
                 case Magenta:return Color.MAGENTA;
                 case Orange:return Color.ORANGE;
                 case Pink:return Color.PINK;
                 
                 case White:return Color.WHITE;
                 case Yellow:return Color.YELLOW;
                 default:
                     case Red:return Color.RED;
             }
        }
        
        protected Paint getInsColor()
        {
            switch (colorIns)
             {
                 case Black: return Color.BLACK;
                 case Blue:return Color.BLUE;
                 case Green:return Color.GREEN;
                 case Gray:return Color.GRAY;
                 case DarkGray:return Color.DARK_GRAY;
                 case LightGray:return Color.LIGHT_GRAY;
                 case Magenta:return Color.MAGENTA;
                 case Orange:return Color.ORANGE;
                 case Pink:return Color.PINK;
                 case Red:return Color.RED;
                 case White:return Color.WHITE;
                 case Yellow:return Color.YELLOW;
                 default:
                     case Cyan:return Color.CYAN;
             }
        }
        
        protected Paint getUniColor()
        {
            switch (colorUni)
             {
                 case Black: return Color.BLACK;
                 case Blue:return Color.BLUE;
                 case Cyan:return Color.CYAN;
                 case Green:return Color.GREEN;
                 case DarkGray:return Color.DARK_GRAY;
                 case LightGray:return Color.LIGHT_GRAY;
                 case Magenta:return Color.MAGENTA;
                 case Orange:return Color.ORANGE;
                 case Pink:return Color.PINK;
                 case Red:return Color.RED;
                 case White:return Color.WHITE;
                 case Yellow:return Color.YELLOW;
                 default:
                     case Gray:return Color.GRAY;
             }
        }
        
        public void setMIPS(String lbBin)
        {
            opcode = lbBin.substring(0, 6);
            int value = Integer.parseInt(opcode);
            if(value == 0)
            {
                RS = lbBin.substring(7, 12);
                RT = lbBin.substring(13, 18);
                RD = lbBin.substring(19, 24);
                shamt=lbBin.substring(25, 30);
                funct = lbBin.substring(31,37);
            }
            else
            {
                RS = lbBin.substring(7, 12);
                RT = lbBin.substring(13, 18);
                RD = lbBin.substring(19, 24);
                shamt = lbBin.substring(24, 29);
                funct = lbBin.substring(29,35);
            }
        }
        
        
        
        
        
	protected void DrawingBlocks(Graphics2D gr2d)
	{
		gr2d.setPaint(Color.BLUE);
       
        //Draw PC
        gr2d.drawImage(imgPC, 50, 300, null);
        
        
        //Draw Instruction Memory
           
        
        gr2d.drawImage(imgInsMem, 140, 340, null);
        
        
        //Draw Register
        gr2d.drawImage(imgReg, 410, 330, null);
        gr2d.drawString("Register", 455, 510);
        
        //Draw ALU
        gr2d.drawImage(imgALU, 700, 345, null);
        gr2d.drawString("ALU", 715, 490);
        
        //Draw Data Memory
        gr2d.drawImage(imgDataMem, 820, 400, null);
        
        gr2d.drawString("Data Mem", 845, 530);
        
        //Draw ADD 4
      	gr2d.drawImage(imgALU, 140, 30, null);
      	gr2d.drawString("ADD", 160, 80);
      	
      	//Draw ADD
       	gr2d.drawImage(imgALU, 685, 80, null);
       	gr2d.drawString("ADD", 705, 130);
       	
       	//Draw Control
       	gr2d.drawImage(imgControl, 370, 220, null);
       	
       	
       	//Draw MUX
        gr2d.drawImage(imgMUX1, 350, 410, null);
        gr2d.drawImage(imgMUX1, 650, 400, null);
        gr2d.drawImage(imgMUX1, 950, 400, null);
       	gr2d.drawImage(imgMUX2, 790, 50, null);
       	
       	
       	//Draw Sign Extend
        gr2d.drawImage(imgSignex,450,520,null);
       	
       	
       	//Draw Shift left 2
        gr2d.drawImage(imgSLL, 618, 165, null);
       	
        //Draw ALU Control
            gr2d.drawImage(imgALUCtrl, 620, 530, null);
            
	}
        
        protected void DrawingIns(Graphics2D gr2d)
        {
		gr2d.setRenderingHints(renderhints);
        gr2d.setStroke (
                new BasicStroke ( thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND ) );
                gr2d.setPaint(getCritColor());
                gr2d.drawLine(50,550,90,550);
                gr2d.drawString("Critical Line",100, 550);
                gr2d.setPaint(getUniColor());
                gr2d.drawLine(50,570, 90,570);
                gr2d.drawString("Unimportant Line",100, 570);
                gr2d.setPaint(getInsColor());
                gr2d.drawLine(50,590, 90,590);
                gr2d.drawString("Instruction Line",100, 590);
        }
        
        @Override 
        protected void finalize() throws Throwable
        {
            super.finalize();
        }
}

enum LineColor {
    Black,Blue,Cyan,Green,Gray,DarkGray,LightGray,Magenta,Orange,Pink,Red,White,Yellow,Default
}
