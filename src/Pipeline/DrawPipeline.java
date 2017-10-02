/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipeline;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Huy
 */

enum NoopState
    {
        oneNoop, twoNoop, none
    }

public class DrawPipeline extends JPanel{

    private int InsNumber;
    private int maxInsNum;

    public int getMaxInsNum() {
        return maxInsNum;
    }
   
    private int curInsNumber[] = {-1,-1,-1,-1,-1};
    private boolean isForwarding;
    private int blockWidth = 50;
    private int blockHeight = 30;
    private int distanceWidth =50;
    private int distanceHeight =30;
    private int dynamicPoint[] = {50,50};
    static Timer timer;
    static int delay=15;
    public static ArrayList<NoopState> isNoop = new ArrayList<NoopState>();
    
    protected int lineNumber=0;
    protected boolean isDone = false;
    protected int xdyn[] ={100,200,300,400,500,600,700,800,900,1000,1100,1200,1300};
    protected int ydyn[] ={65,125,185,245,305,365,425,485,545,605,665,725,785};
    private int StartingPoint[][]={
        {100,65,500,0},{200,125,600,0},{300,185,700,0},{400,245,800,0},{500,305,900,0},{600,365,1000,0},{700,425,1100,0},{800,485,1200,0},{900,545,1300,0},{1000,605,1400,0},{1100,665,1500,0},{1200,725,1600,0},{1300,785,1700,0}
    };
    
    private BufferedImage imgID =null;
    private BufferedImage imgIF = null;
    private BufferedImage imgALU =null;
    private BufferedImage imgMEM = null;
    private BufferedImage imgWB = null;
    private BufferedImage imgNoop =null;
    
    DrawPipeline(int InsNumber){
        this.getImage();
        this.InsNumber = InsNumber;
        for(int i=0;i<isNoop.size();i++)
        {
            if(i==0)
            {
                curInsNumber[i]=i;
                maxInsNum =curInsNumber[i];
            }
            if(isNoop.get(i)==NoopState.none)
            {
                curInsNumber[i+1]=curInsNumber[i]+1;
                maxInsNum =curInsNumber[i+1];
            }
            else if(isNoop.get(i)== NoopState.oneNoop )
            {
                curInsNumber[i+1]=curInsNumber[i]+2;
                maxInsNum =curInsNumber[i+1];
            }
            else if(isNoop.get(i)==NoopState.twoNoop)
            {
                curInsNumber[i+1]=curInsNumber[i]+3;
                maxInsNum =curInsNumber[i+1];
            }
        }
        
        timer = new Timer(delay,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.setInitialDelay(250);
        timer.start();
    }
    
    protected void Calculate(int X1, int Y1, int X2, int Y2,int index)
	{
		if(xdyn[index] == 0 && ydyn[index] == 0)
		{	
			xdyn[index] = X1;
			ydyn[index] = Y1;
		}
		if(( X1<X2 && xdyn[index]<X2)||(X1>X2 && xdyn[index]>X2)||(Y1<Y2 && ydyn[index] <Y2)||(Y1>=Y2&&ydyn[index]>Y2))
			{	
				int Xvector= Y2-Y1;
				int Yvector = -(X2-X1);
				if(X1 != X2)
				{
					if(X2>X1)
						xdyn[index] += 2;
					else if (X2<X1)
						xdyn[index] -= 2;
					if(Y1!=Y2)
						ydyn[index] = Math.abs((Xvector*X1+Yvector*Y1-Xvector*xdyn[index])/(Yvector));
					else 
						ydyn[index] = Y1;
				}
				else
				{
					if(Y1<Y2)
						ydyn[index] += 2;
					if(Y1>=Y2)
						ydyn[index] -= 2;
				}
				isDone = false;
				
			}
		if(X2 == xdyn[index] && Y2 == ydyn[index])
		{
			isDone = true;
		}
		else if((X2 == xdyn[index] -1 && Y2 == ydyn[index] -1) || (X2 == xdyn[index] &&Y2==ydyn[index]-1)||(X2==xdyn[index]-1&& Y2==ydyn[index]))
		{
			isDone = true;
		}
		else if((X2 == xdyn[index] +1 && Y2 == ydyn[index] +1)|| (X2 == xdyn[index] &&Y2==ydyn[index]+1)||(X2==xdyn[index]+1&& Y2==ydyn[index]))
		{
			isDone = true;
		}
	}
    
  
    
    private void getImage()
    {
        try {
        InputStream streamID = getClass().getResourceAsStream("/ID.png");
        imgID = ImageIO.read(streamID);
        
        InputStream streamIF = getClass().getResourceAsStream("/IF.png");
        imgIF = ImageIO.read(streamIF);
        
        InputStream streamALU = getClass().getResourceAsStream("/EX.png");
        imgALU = ImageIO.read(streamALU);
        
        InputStream streamMEM = getClass().getResourceAsStream("/MEM.png");
        imgMEM = ImageIO.read(streamMEM);
        
        InputStream streamWB = getClass().getResourceAsStream("/WB.png");
        imgWB = ImageIO.read(streamWB);
        
        InputStream streamNoop = getClass().getResourceAsStream("/Noop.png");
        imgNoop = ImageIO.read(streamNoop);
        } catch (IOException ex) {
            Logger.getLogger(DrawPipeline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void DrawingBlocks(Graphics2D gr2d)
    {
        gr2d.setPaint(Color.RED);
        int xpoint, ypoint;
        for(int i=0;i<InsNumber;i++)
        {
            xpoint = dynamicPoint[0];
            ypoint = dynamicPoint[1];
            switch(Pipeline.getInsType().get(i))
            {
                case ADD: gr2d.drawString("ADD", 5, ypoint+15);break;
                case SUB: gr2d.drawString("SUB",5,ypoint+15);break;
                case AND: gr2d.drawString("AND",5,ypoint+15);break;
                case OR: gr2d.drawString("OR",5,ypoint+15);break;
                case SLT:gr2d.drawString("SLT",5,ypoint+15);break;
                case LW:gr2d.drawString("LW",5,ypoint+15);break;
                case SW:gr2d.drawString("SW",5,ypoint+15);break;
                default: break;
            }
            for(int j=0;j<5;j++)
            {
                if(j==0)
                    gr2d.drawImage(imgID, xpoint, ypoint, null);
                else if(j==1)
                    gr2d.drawImage(imgIF, xpoint, ypoint, null);
                else if(j==2)
                    gr2d.drawImage(imgALU, xpoint, ypoint, null);
                else if(j==3)
                    gr2d.drawImage(imgMEM, xpoint, ypoint, null);
                else if(j==4)
                    gr2d.drawImage(imgWB, xpoint, ypoint, null);
                xpoint += blockWidth + distanceWidth;
            }
            dynamicPoint[0] += blockWidth + distanceWidth;
            dynamicPoint[1] += blockHeight + distanceHeight;
            if(i<InsNumber-1&&InsNumber!=1)
            {
                if(isNoop.get(i) == NoopState.oneNoop)
                {
                    xpoint = dynamicPoint[0];
                    ypoint = dynamicPoint[1];
                    for(int j=0;j<5;j++)
                    {
                        gr2d.drawImage(imgNoop, xpoint, ypoint, null);
                        xpoint += blockWidth + distanceWidth;
                    }
                    dynamicPoint[0] += blockWidth + distanceWidth;
                    dynamicPoint[1] += blockHeight + distanceHeight;
                }
                else if(isNoop.get(i) == NoopState.twoNoop)
                {
                    for(int turn =1; turn <=2;turn++)
                    {
                        xpoint = dynamicPoint[0];
                        ypoint = dynamicPoint[1];
                        for(int j=0;j<5;j++)
                        {
                            gr2d.drawImage(imgNoop, xpoint, ypoint, null);
                            xpoint += blockWidth + distanceWidth;
                        }
                        dynamicPoint[0] += blockWidth + distanceWidth;
                        dynamicPoint[1] += blockHeight + distanceHeight;
                    }
                }
            }
        }
        dynamicPoint[0] = 50;
        dynamicPoint[1] = 50;
    }
    
    private void DrawingAnimatedLine(Graphics2D gr2d,int index)
    {
        gr2d.setPaint(Color.RED);
        gr2d.setStroke (
                new BasicStroke ( 4.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND ) );
       if(xdyn[index] != 0 && ydyn[index]!= 0)
        {
        Calculate(StartingPoint[index][0], StartingPoint[index][1], StartingPoint[index][0]+distanceWidth, StartingPoint[index][1], index);
        gr2d.drawLine(StartingPoint[index][0], StartingPoint[index][1],xdyn[index],ydyn[index]);
        
        if(isDone)
        {
            StartingPoint[index][0] += distanceWidth + blockWidth;
            xdyn[index] = StartingPoint[index][0];
            StartingPoint[index][3]++;
            if(StartingPoint[index][0] == StartingPoint[index][2])
            {
                xdyn[index]=0;
                ydyn[index]=0;
            }
        }
        }
        if(StartingPoint[index][3]>=1)
        {
            for(int i=0;i<StartingPoint[index][3];i++)
            {
                if(i==0)
                    gr2d.drawLine(StartingPoint[index][2]-400, StartingPoint[index][1], StartingPoint[index][2]-350,StartingPoint[index][1] );
                if(i==1)
                {
                    gr2d.drawLine(StartingPoint[index][2]-400, StartingPoint[index][1], StartingPoint[index][2]-350,StartingPoint[index][1] );
                    gr2d.drawLine(StartingPoint[index][2]-300, StartingPoint[index][1], StartingPoint[index][2]-250,StartingPoint[index][1] );
                }
                if(i==2)
                {
                    gr2d.drawLine(StartingPoint[index][2]-400, StartingPoint[index][1], StartingPoint[index][2]-350,StartingPoint[index][1] );
                    gr2d.drawLine(StartingPoint[index][2]-300, StartingPoint[index][1], StartingPoint[index][2]-250,StartingPoint[index][1] );
                    gr2d.drawLine(StartingPoint[index][2]-200, StartingPoint[index][1], StartingPoint[index][2]-150,StartingPoint[index][1] );
                }
                if(i==3)
                {
                    gr2d.drawLine(StartingPoint[index][2]-400, StartingPoint[index][1], StartingPoint[index][2]-350,StartingPoint[index][1] );
                    gr2d.drawLine(StartingPoint[index][2]-300, StartingPoint[index][1], StartingPoint[index][2]-250,StartingPoint[index][1] );
                    gr2d.drawLine(StartingPoint[index][2]-200, StartingPoint[index][1], StartingPoint[index][2]-150,StartingPoint[index][1] );
                    gr2d.drawLine(StartingPoint[index][2]-100, StartingPoint[index][1], StartingPoint[index][2]-50,StartingPoint[index][1] );
                }
            }
        }
        if(index == maxInsNum && StartingPoint[index][0] == StartingPoint[index][2])
        {
            timer.stop();
            for(int i=0;i<Pipeline.getBtnDelLenh().size();i++)
        {
            Pipeline.getBtnDelLenh().get(i).setEnabled(true);
        }
        }
    }
    
    private void DrawingAllPipeline(Graphics2D gr2d)
    {
        int i;
        for(i=0;i<5;i++)
        {
            if(i==0)
            {
                DrawingAnimatedLine(gr2d, 0);
            }
            else if(i!=0)
            {
                if(curInsNumber[i]!= -1)
                {
                    if(curInsNumber[i] == curInsNumber[i-1]+1 && StartingPoint[curInsNumber[i-1]][3] >=1)
                        DrawingAnimatedLine(gr2d, curInsNumber[i]);
                    else if(curInsNumber[i] == curInsNumber[i-1]+2 && StartingPoint[curInsNumber[i-1]][3] >=2)
                        DrawingAnimatedLine(gr2d, curInsNumber[i]);
                    else if(curInsNumber[i] == curInsNumber[i-1]+3 && StartingPoint[curInsNumber[i-1]][3] >=3)
                        DrawingAnimatedLine(gr2d, curInsNumber[i]);
                }
            }
        }
        
        gr2d.dispose();
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        DrawingBlocks((Graphics2D)g);
        DrawingAllPipeline((Graphics2D)g);
        
    }
    
}
