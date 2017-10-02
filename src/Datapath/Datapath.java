/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datapath;


import Pipeline.Pipeline;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;




/**
 *
 * @author THELINH
 */
public class Datapath extends javax.swing.JFrame {

    
    /**
     * Creates new form Datapath
     */
    private String inputlink = System.getProperty("user.home") + File.separator+ "Documents" + File.separator+"DatapathAndPipeline"+File.separator+ "Datapath"+File.separator+"config.txt";
    
    
    private void getConfig() 
    {
        
        File file = new File(inputlink);
        if(!file.exists())
        {
            ModelDrawing.colorCrit = LineColor.Red;
            ModelDrawing.colorIns = LineColor.Cyan;
            ModelDrawing.colorUni = LineColor.Gray;
            ModelDrawing.thickness = 3.5f;
            ModelDrawing.renderhints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            ModelDrawing.renderhints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_DEFAULT);
            return;
        }
        try
        {  
            FileInputStream fileinput = new FileInputStream(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileinput));
            String critcolor, inscolor, unicolor, thickness, aa,render;
            String line;
            while((line = reader.readLine())!=null)
            {
                if(line.contains("CritColor"))
                {
                    critcolor = line.substring(line.indexOf("CritColor")+("CritColor").length()+3, line.length());
                    switch(critcolor)
                    {
                    case "Black": ModelDrawing.colorCrit = LineColor.Black; break;
                    case "Blue": ModelDrawing.colorCrit = LineColor.Blue; break;
                    case "Cyan": ModelDrawing.colorCrit = LineColor.Cyan; break;
                    case "Green": ModelDrawing.colorCrit = LineColor.Green; break;
                    case "Gray": ModelDrawing.colorCrit = LineColor.Gray; break;
                    case "LightGray": ModelDrawing.colorCrit = LineColor.LightGray; break;
                    case "DarkGray": ModelDrawing.colorCrit = LineColor.DarkGray; break;
                    case "Red": ModelDrawing.colorCrit = LineColor.Red; break;
                    case "Magenta": ModelDrawing.colorCrit = LineColor.Magenta; break;
                    case "Orange": ModelDrawing.colorCrit = LineColor.Orange; break;
                    case "Pink": ModelDrawing.colorCrit = LineColor.Pink; break;
                    case "White": ModelDrawing.colorCrit = LineColor.White; break;
                    case "Yellow": ModelDrawing.colorCrit = LineColor.Yellow; break;
                    default : ModelDrawing.colorCrit = LineColor.Default; break;
                    }
                }
                else if(line.contains("InsColor"))
                {
                    inscolor = line.substring(line.indexOf("InsColor")+("InsColor").length()+3, line.length());
                    switch(inscolor)
                    {
                    case "Black": ModelDrawing.colorIns = LineColor.Black; break;
                    case "Blue": ModelDrawing.colorIns = LineColor.Blue; break;
                    case "Cyan": ModelDrawing.colorIns = LineColor.Cyan; break;
                    case "Green": ModelDrawing.colorIns = LineColor.Green; break;
                    case "Gray": ModelDrawing.colorIns = LineColor.Gray; break;
                    case "LightGray": ModelDrawing.colorIns = LineColor.LightGray; break;
                    case "DarkGray": ModelDrawing.colorIns = LineColor.DarkGray; break;
                    case "Red": ModelDrawing.colorIns = LineColor.Red; break;
                    case "Magenta": ModelDrawing.colorIns = LineColor.Magenta; break;
                    case "Orange": ModelDrawing.colorIns = LineColor.Orange; break;
                    case "Pink": ModelDrawing.colorIns = LineColor.Pink; break;
                    case "White": ModelDrawing.colorIns = LineColor.White; break;
                    case "Yellow": ModelDrawing.colorIns = LineColor.Yellow; break;
                    default :ModelDrawing.colorIns = LineColor.Default; break;
                    }
                }
                else if(line.contains("UniColor"))
                {
                    unicolor = line.substring(line.indexOf("UniColor")+("UniColor").length()+3, line.length());
                    switch(unicolor)
                    {
                    case "Black": ModelDrawing.colorUni = LineColor.Black; break;
                    case "Blue": ModelDrawing.colorUni = LineColor.Blue; break;
                    case "Cyan": ModelDrawing.colorUni = LineColor.Cyan; break;
                    case "Green": ModelDrawing.colorUni = LineColor.Green; break;
                    case "Gray": ModelDrawing.colorUni = LineColor.Gray; break;
                    case "LightGray": ModelDrawing.colorUni = LineColor.LightGray; break;
                    case "DarkGray": ModelDrawing.colorUni = LineColor.DarkGray; break;
                    case "Red": ModelDrawing.colorUni = LineColor.Red; break;
                    case "Magenta": ModelDrawing.colorUni = LineColor.Magenta; break;
                    case "Orange": ModelDrawing.colorUni = LineColor.Orange; break;
                    case "Pink": ModelDrawing.colorUni = LineColor.Pink; break;
                    case "White": ModelDrawing.colorUni = LineColor.White; break;
                    case "Yellow": ModelDrawing.colorUni = LineColor.Yellow; break;
                    default :ModelDrawing.colorUni = LineColor.Default; break;
                    }
                }
                else if(line.contains("Thickness"))
                {
                    thickness = line.substring(line.indexOf("Thickness")+("Thíckness").length()+3, line.length());
                    ModelDrawing.thickness = Float.parseFloat(thickness);
                }
                else if(line.contains("Anti-Aliasing"))
                {
                    aa = line.substring(line.indexOf("Anti-Aliasing")+("Anti-Aliasing").length()+3, line.length());
                    if(Boolean.parseBoolean(aa))
                        ModelDrawing.renderhints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    else
                        ModelDrawing.renderhints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                }
                else if(line.contains("Rendering"))
                {
                    render = line.substring(line.indexOf("Rendering")+("Rendering").length()+3, line.length());
                    if("Default".equals(render))
                        ModelDrawing.renderhints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_DEFAULT);
                    else if("Quality".equals(render))
                        ModelDrawing.renderhints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                    else if("Speed".equals(render))
                        ModelDrawing.renderhints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
                }
            }
            
            reader.close();
            fileinput.close();
        }
        catch(IOException e)
        {
            WriteLog(e);
        }
    }
    public Datapath()   {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icon.png"));
        Image image = icon.getImage();
        this.setIconImage(image);
        System.out.println(System.getProperty("os.name").toLowerCase());
        clicked = cmd.NONE;
        initComponents();
        init();
        
        getConfig();
    }

    private void init(){
        
        txtImed_beq = new javax.swing.JTextField();
        lblParentheses_1 = new javax.swing.JLabel();
        lblParentheses_2 = new javax.swing.JLabel();
        txtImed_lw =new javax.swing.JTextField();
        lblSpace_lw1 = new javax.swing.JLabel();
        cboRS_lw = new javax.swing.JComboBox<>();
        binary = new StringBuilder("");
        hexa = new StringBuilder("");
        regMap = new HashMap();
        
        pnlClickedButton.add(txtImed_beq);
        pnlClickedButton.add(txtImed_lw);
        pnlClickedButton.add(lblParentheses_1);
        pnlClickedButton.add(lblParentheses_2);
        pnlClickedButton.add(lblSpace_lw1);
        pnlClickedButton.add(cboRS_lw);
        
        txtImed_beq.setVisible(false);
        lblParentheses_1.setVisible(false);
        lblParentheses_2.setVisible(false);
        txtImed_lw.setVisible(false);
        lblSpace_lw1.setVisible(false);
        cboRS_lw.setVisible(false);
        
        regMap.put("s0", "10000"); regMap.put("s1", "10001");
        regMap.put("s2", "10010"); regMap.put("s3", "10011");
        regMap.put("s4", "10100"); regMap.put("s5", "10101");
        regMap.put("s6", "10110"); regMap.put("s7", "10111");
        regMap.put("t0", "01000"); regMap.put("t1", "01001");
        regMap.put("t2", "01010"); regMap.put("t3", "01011");
        regMap.put("t4", "01100"); regMap.put("t5", "01101");
        regMap.put("t6", "01110"); regMap.put("t7", "01111");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCommand = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnSub = new javax.swing.JButton();
        btnOr = new javax.swing.JButton();
        btnAnd = new javax.swing.JButton();
        btnSlt = new javax.swing.JButton();
        btnBeq = new javax.swing.JButton();
        btnLw = new javax.swing.JButton();
        btnSw = new javax.swing.JButton();
        rdoEqual = new javax.swing.JRadioButton();
        pnlClickedButton = new javax.swing.JPanel();
        lblClickedCommand = new javax.swing.JLabel();
        lblSpace1 = new javax.swing.JLabel();
        cboRS = new javax.swing.JComboBox<>();
        lblSpace2 = new javax.swing.JLabel();
        cboRT = new javax.swing.JComboBox<>();
        cboRD = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnSummit = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnContinue = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnForward = new javax.swing.JButton();
        sldSpeed = new javax.swing.JSlider();
        lbSpeed = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtBinary = new javax.swing.JTextField();
        txtHexa = new javax.swing.JTextField();
        lblBinary = new javax.swing.JLabel();
        lblHexa = new javax.swing.JLabel();
        scrpModelDraw = new javax.swing.JScrollPane();
        mnbar = new javax.swing.JMenuBar();
        mnuCheDo = new javax.swing.JMenu();
        mnuiDatapath = new javax.swing.JMenuItem();
        mnuiPipeline = new javax.swing.JMenuItem();
        mnuTrangThai = new javax.swing.JMenu();
        mnuiSimulate = new javax.swing.JMenuItem();
        mnuiStop = new javax.swing.JMenuItem();
        mnuiContinue = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuiGuide = new javax.swing.JMenuItem();
        mnuiSetup = new javax.swing.JMenuItem();
        mnuiAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mô phỏng Datapath");
        setExtendedState(6);
        setName("Datapath"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1300, 558));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlCommand.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn Lệnh"));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 0, 0));
        btnAdd.setText("add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSub.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSub.setForeground(new java.awt.Color(255, 0, 0));
        btnSub.setText("sub");
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });

        btnOr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnOr.setForeground(new java.awt.Color(255, 0, 0));
        btnOr.setText("or");
        btnOr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrActionPerformed(evt);
            }
        });

        btnAnd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAnd.setForeground(new java.awt.Color(255, 0, 0));
        btnAnd.setText("and");
        btnAnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndActionPerformed(evt);
            }
        });

        btnSlt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSlt.setForeground(new java.awt.Color(255, 0, 0));
        btnSlt.setText("slt");
        btnSlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSltActionPerformed(evt);
            }
        });

        btnBeq.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBeq.setForeground(new java.awt.Color(255, 0, 0));
        btnBeq.setText("beq");
        btnBeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeqActionPerformed(evt);
            }
        });

        btnLw.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLw.setForeground(new java.awt.Color(255, 0, 0));
        btnLw.setText("lw");
        btnLw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLwActionPerformed(evt);
            }
        });

        btnSw.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSw.setForeground(new java.awt.Color(255, 0, 0));
        btnSw.setText("sw");
        btnSw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwActionPerformed(evt);
            }
        });

        rdoEqual.setText("equal");
        rdoEqual.setEnabled(false);

        javax.swing.GroupLayout pnlCommandLayout = new javax.swing.GroupLayout(pnlCommand);
        pnlCommand.setLayout(pnlCommandLayout);
        pnlCommandLayout.setHorizontalGroup(
            pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCommandLayout.createSequentialGroup()
                .addGroup(pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlCommandLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCommandLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSlt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAnd, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCommandLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlCommandLayout.createSequentialGroup()
                                .addComponent(btnBeq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoEqual)))))
                .addContainerGap())
        );
        pnlCommandLayout.setVerticalGroup(
            pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCommandLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(5, 5, 5)
                .addComponent(btnSub)
                .addGap(5, 5, 5)
                .addComponent(btnOr)
                .addGap(5, 5, 5)
                .addComponent(btnAnd)
                .addGap(5, 5, 5)
                .addComponent(btnSlt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSw)
                .addGap(4, 4, 4)
                .addComponent(btnLw)
                .addGap(5, 5, 5)
                .addGroup(pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBeq)
                    .addComponent(rdoEqual)))
        );

        pnlClickedButton.setMinimumSize(new java.awt.Dimension(341, 34));

        lblSpace1.setText(", $");
        lblSpace1.setMinimumSize(new java.awt.Dimension(12, 14));

        cboRS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<choose>", "s0", "s1", "s2", "s3", "s4", "s5", "s6", "s7", "t0", "t1", "t2", "t3", "t4", "t5", "t6", "t7" }));

        lblSpace2.setText(", $");
        lblSpace2.setMinimumSize(new java.awt.Dimension(12, 14));

        cboRT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<choose>", "s0", "s1", "s2", "s3", "s4", "s5", "s6", "s7", "t0", "t1", "t2", "t3", "t4", "t5", "t6", "t7" }));

        cboRD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<choose>", "s0", "s1", "s2", "s3", "s4", "s5", "s6", "s7", "t0", "t1", "t2", "t3", "t4", "t5", "t6", "t7" }));

        javax.swing.GroupLayout pnlClickedButtonLayout = new javax.swing.GroupLayout(pnlClickedButton);
        pnlClickedButton.setLayout(pnlClickedButtonLayout);
        pnlClickedButtonLayout.setHorizontalGroup(
            pnlClickedButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClickedButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClickedCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cboRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(lblSpace1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(cboRS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(lblSpace2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(cboRT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        pnlClickedButtonLayout.setVerticalGroup(
            pnlClickedButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClickedButtonLayout.createSequentialGroup()
                .addGroup(pnlClickedButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClickedButtonLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(pnlClickedButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSpace2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSpace1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboRS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboRT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlClickedButtonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblClickedCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Điều khiển"));

        btnSummit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSummit.setText("Mô phỏng");
        btnSummit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummitActionPerformed(evt);
            }
        });

        btnPause.setText("Dừng lại");
        btnPause.setEnabled(false);
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnContinue.setText("Tiếp tục");
        btnContinue.setEnabled(false);
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled.png"))); // NOI18N
        btnBack.setEnabled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled2.png"))); // NOI18N
        btnForward.setEnabled(false);
        btnForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForwardActionPerformed(evt);
            }
        });

        sldSpeed.setMaximum(50);
        sldSpeed.setMinimum(1);
        sldSpeed.setValue(40);
        sldSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldSpeedStateChanged(evt);
            }
        });

        lbSpeed.setText("Tốc độ");

        btnReset.setLabel("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.setPreferredSize(new java.awt.Dimension(61, 23));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSummit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbSpeed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sldSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnForward, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnSummit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSpeed))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnForward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        txtBinary.setEditable(false);

        txtHexa.setEditable(false);

        lblBinary.setText("Mã nhị phân:");

        lblHexa.setText("Mã thập lục phân:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBinary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHexa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHexa, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBinary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBinary)
                    .addComponent(lblHexa)
                    .addComponent(txtHexa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        scrpModelDraw.setBorder(javax.swing.BorderFactory.createTitledBorder("Mô hình"));

        mnuCheDo.setText("Chế độ");

        mnuiDatapath.setText("Mô phỏng Datapath");
        mnuiDatapath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiDatapathActionPerformed(evt);
            }
        });
        mnuCheDo.add(mnuiDatapath);

        mnuiPipeline.setText("Mô phỏng Pipeline");
        mnuiPipeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiPipelineActionPerformed(evt);
            }
        });
        mnuCheDo.add(mnuiPipeline);

        mnbar.add(mnuCheDo);

        mnuTrangThai.setText("Trạng Thái");
        mnuTrangThai.setToolTipText("");

        mnuiSimulate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        mnuiSimulate.setText("Mô phỏng");
        mnuiSimulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiSimulateActionPerformed(evt);
            }
        });
        mnuTrangThai.add(mnuiSimulate);

        mnuiStop.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        mnuiStop.setText("Dừng");
        mnuiStop.setEnabled(false);
        mnuiStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiStopActionPerformed(evt);
            }
        });
        mnuTrangThai.add(mnuiStop);

        mnuiContinue.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        mnuiContinue.setText("Tiếp tục");
        mnuiContinue.setEnabled(false);
        mnuiContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiContinueActionPerformed(evt);
            }
        });
        mnuTrangThai.add(mnuiContinue);

        mnbar.add(mnuTrangThai);

        mnuHelp.setText("Giúp đỡ");

        mnuiGuide.setText("Hướng dẫn");
        mnuiGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiGuideActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuiGuide);

        mnuiSetup.setText("Cài đặt");
        mnuiSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiSetupActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuiSetup);

        mnuiAbout.setText("Về chương trình");
        mnuiAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiAboutActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuiAbout);

        mnbar.add(mnuHelp);

        setJMenuBar(mnbar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrpModelDraw))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlClickedButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addComponent(scrpModelDraw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlClickedButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void Simulate()
    {
        ModelDrawing.isBack = false;
        ModelDrawing.isForward = false;
        ModelDrawing.isClear= false;
        try
        {
            if(TransferCommand() && scrpModelDraw.getViewport().getView() != null)
            {   
                drawpanel.setMIPS(txtBinary.getText());
                if(clicked == cmd.BEQ)
                {
                    ((beqDrawing)drawpanel).setIsEqual(rdoEqual.isSelected());
                }
                ModelDrawing.timer.start();
                btnSummit.setEnabled(false);
                mnuiSimulate.setEnabled(false);
                mnuiSetup.setEnabled(false);
                btnPause.setEnabled(true);
                btnContinue.setEnabled(true);
                mnuiContinue.setEnabled(true);
                mnuiStop.setEnabled(true);
            }
            else
            {
                btnSummit.setEnabled(true);
            }
        }
        catch(NumberFormatException e)
        {
            WriteLog(e);
            JOptionPane.showMessageDialog(null, "Không được nhập kí tự khác chữ số", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void ContinueSimulate()
    {
        ModelDrawing.isBack = false;
        ModelDrawing.isForward = false;
        ModelDrawing.isClear= false;
        ModelDrawing.timer.restart();
        btnBack.setEnabled(false);
        btnForward.setEnabled(false);
    }
    
    private void StopSimulate()
    {
        ModelDrawing.timer.stop();
        btnBack.setEnabled(true);
        btnForward.setEnabled(true);
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
            resetProperties();
            clicked = cmd.ADD;
            
            lblClickedCommand.setText("     add $");
            lblSpace1.setText(", $");
            lblSpace2.setText(", $");
            txtImed_beq.setVisible(false);
            cboRT.setVisible(true);
            cboRS.setVisible(true);
            lblSpace1.setVisible(true);
            lblSpace2.setVisible(true);
            lblParentheses_1.setVisible(false);
            lblParentheses_2.setVisible(false);
            cboRS_lw.setVisible(false);
            txtImed_lw.setVisible(false);
            
            drawpanel = new RtypeDrawing();
            drawpanel.setPreferredSize(new Dimension(1050,660));
            scrpModelDraw.setViewportView(drawpanel);
            ModelDrawing.timer.setDelay(sldSpeed.getMaximum() - sldSpeed.getValue()+1);
            ModelDrawing.timer.stop();
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubActionPerformed
        
            resetProperties();
            clicked = cmd.SUB;
            lblClickedCommand.setText("     sub $");
            
            lblSpace1.setText(", $");
            lblSpace2.setText(", $");
            txtImed_beq.setVisible(false);
            cboRT.setVisible(true);
            cboRS.setVisible(true);
            lblSpace1.setVisible(true);
            lblSpace2.setVisible(true);
            lblParentheses_1.setVisible(false);
            lblParentheses_2.setVisible(false);
            cboRS_lw.setVisible(false);
            txtImed_lw.setVisible(false);
            
            drawpanel = new RtypeDrawing();
            drawpanel.setPreferredSize(new Dimension(1050,660));
            scrpModelDraw.setViewportView(drawpanel);
            ModelDrawing.timer.setDelay(sldSpeed.getMaximum() - sldSpeed.getValue()+1);
            ModelDrawing.timer.stop();
        
    }//GEN-LAST:event_btnSubActionPerformed

    private void btnOrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrActionPerformed
        
            resetProperties();
            clicked = cmd.OR;
            lblClickedCommand.setText("      or $");
            
            lblSpace1.setText(", $");
            lblSpace2.setText(", $");
            txtImed_beq.setVisible(false);
            cboRT.setVisible(true);
            cboRS.setVisible(true);
            lblSpace1.setVisible(true);
            lblSpace2.setVisible(true);
            lblParentheses_1.setVisible(false);
            lblParentheses_2.setVisible(false);
            cboRS_lw.setVisible(false);
            txtImed_lw.setVisible(false);
            
            drawpanel = new RtypeDrawing();
            drawpanel.setPreferredSize(new Dimension(1050,660));
            scrpModelDraw.setViewportView(drawpanel);
            ModelDrawing.timer.setDelay(sldSpeed.getMaximum() - sldSpeed.getValue()+1);
            ModelDrawing.timer.stop();
        
    }//GEN-LAST:event_btnOrActionPerformed

    private void btnAndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndActionPerformed
        
            resetProperties();
            clicked = cmd.AND;
            lblClickedCommand.setText("     and $");
            
            lblSpace1.setText(", $");
            lblSpace2.setText(", $");
            
            txtImed_beq.setVisible(false);
            cboRT.setVisible(true);
            cboRS.setVisible(true);
            lblSpace1.setVisible(true);
            lblSpace2.setVisible(true);
            lblParentheses_1.setVisible(false);
            lblParentheses_2.setVisible(false);
            cboRS_lw.setVisible(false);
            txtImed_lw.setVisible(false);
            
            drawpanel = new RtypeDrawing();
            drawpanel.setPreferredSize(new Dimension(1050,660));
            scrpModelDraw.setViewportView(drawpanel);
            ModelDrawing.timer.setDelay(sldSpeed.getMaximum() - sldSpeed.getValue()+1);
            ModelDrawing.timer.stop();
        
    }//GEN-LAST:event_btnAndActionPerformed

    private void btnSltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSltActionPerformed
        
            resetProperties();
            clicked = cmd.SLT;
            lblClickedCommand.setText("     slt $");
            
            lblSpace1.setText(", $");
            lblSpace2.setText(", $");

            txtImed_beq.setVisible(false);
            cboRT.setVisible(true);
            cboRS.setVisible(true);
            lblSpace1.setVisible(true);
            lblSpace2.setVisible(true);
            lblParentheses_1.setVisible(false);
            lblParentheses_2.setVisible(false);
            cboRS_lw.setVisible(false);
            txtImed_lw.setVisible(false);
            
            drawpanel = new RtypeDrawing();
            drawpanel.setPreferredSize(new Dimension(1050,660));
            scrpModelDraw.setViewportView(drawpanel);
            ModelDrawing.timer.setDelay(sldSpeed.getMaximum() - sldSpeed.getValue()+1);
            ModelDrawing.timer.stop();
        
    }//GEN-LAST:event_btnSltActionPerformed

    private void btnBeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeqActionPerformed
        
            resetProperties();
            clicked = cmd.BEQ;
            lblClickedCommand.setText("     beq $");
            
            lblSpace1.setText(", $");
            lblSpace2.setText(",  ");

            txtImed_beq.setBounds(329,4,88,26);
            txtImed_beq.setText("");
            txtImed_beq.setVisible(true);
            

            cboRT.setVisible(false);
            cboRS.setVisible(true);
            lblSpace1.setVisible(true);
            lblParentheses_1.setVisible(false);
            lblParentheses_2.setVisible(false);
            cboRS_lw.setVisible(false);
            txtImed_lw.setVisible(false);
            rdoEqual.setEnabled(true);
            
            drawpanel = new beqDrawing();
            drawpanel.setPreferredSize(new Dimension(1050,660));
            scrpModelDraw.setViewportView(drawpanel);
            ModelDrawing.timer.setDelay(sldSpeed.getMaximum() - sldSpeed.getValue()+1);
            ModelDrawing.timer.stop();
        
        
    }//GEN-LAST:event_btnBeqActionPerformed

    private void btnLwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLwActionPerformed
       
            resetProperties();
            clicked = cmd.LW;
            lblClickedCommand.setText("      lw $");
            
            
            lblSpace1.setText(", ");
            lblSpace2.setVisible(false);
            
            txtImed_lw.setText("");
            txtImed_lw.setSize(30, 26);
            txtImed_lw.setLocation(170,4);            
            txtImed_lw.setVisible(true);
            
            lblParentheses_1.setText("(");
            lblParentheses_1.setSize(5,26);
            lblParentheses_1.setLocation(205,4);
            lblParentheses_1.setVisible(true);
            
            cboRS_lw.setSize(90,25);
            cboRS_lw.setLocation(210,4);
            cboRS_lw.addItem("<choose>");
            cboRS_lw.addItem("s0"); cboRS_lw.addItem("s1");
            cboRS_lw.addItem("s2"); cboRS_lw.addItem("s3"); 
            cboRS_lw.addItem("s4"); cboRS_lw.addItem("s5");
            cboRS_lw.addItem("s6"); cboRS_lw.addItem("s7"); 
            cboRS_lw.addItem("t0"); cboRS_lw.addItem("t1");
            cboRS_lw.addItem("t2"); cboRS_lw.addItem("t3");
            cboRS_lw.addItem("t4"); cboRS_lw.addItem("t5");
            cboRS_lw.addItem("t6"); cboRS_lw.addItem("t7");
            cboRS_lw.setVisible(true);
            
            lblParentheses_2.setText((")"));
            lblParentheses_2.setSize(5,26);
            lblParentheses_2.setLocation(300,4);
            lblParentheses_2.setVisible(true);
            
            cboRS.setVisible(false);
            cboRT.setVisible(false);
            txtImed_beq.setVisible(false);
            
            drawpanel = new lwDrawing();
            drawpanel.setPreferredSize(new Dimension(1050,660));
            scrpModelDraw.setViewportView(drawpanel);
            ModelDrawing.timer.setDelay(sldSpeed.getMaximum() - sldSpeed.getValue()+1);
            ModelDrawing.timer.stop();
        
    }//GEN-LAST:event_btnLwActionPerformed

    private void btnSwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwActionPerformed

            resetProperties();
            clicked = cmd.SW;
            lblClickedCommand.setText("      sw $");
            
            lblSpace1.setText(", ");
            lblSpace2.setVisible(false);
            
            txtImed_lw.setText("");
            txtImed_lw.setSize(30, 26);
            txtImed_lw.setLocation(170,4);            
            txtImed_lw.setVisible(true);
            
            lblParentheses_1.setText("(");
            lblParentheses_1.setSize(5,26);
            lblParentheses_1.setLocation(205,4);
            lblParentheses_1.setVisible(true);
            
            cboRS_lw.setSize(90,25);
            cboRS_lw.setLocation(210,4);
            cboRS_lw.addItem("<choose>");
            cboRS_lw.addItem("s0"); cboRS_lw.addItem("s1");
            cboRS_lw.addItem("s2"); cboRS_lw.addItem("s3"); 
            cboRS_lw.addItem("s4"); cboRS_lw.addItem("s5");
            cboRS_lw.addItem("s6"); cboRS_lw.addItem("s7"); 
            cboRS_lw.addItem("t0"); cboRS_lw.addItem("t1");
            cboRS_lw.addItem("t2"); cboRS_lw.addItem("t3");
            cboRS_lw.addItem("t4"); cboRS_lw.addItem("t5");
            cboRS_lw.addItem("t6"); cboRS_lw.addItem("t7");
            cboRS_lw.setVisible(true);
            
            lblParentheses_2.setText((")"));
            lblParentheses_2.setSize(5,26);
            lblParentheses_2.setLocation(300,4);
            lblParentheses_2.setVisible(true);
            
            cboRS.setVisible(false);
            cboRT.setVisible(false);
            txtImed_beq.setVisible(false);
            
            
            drawpanel = new swDrawing();
            drawpanel.setPreferredSize(new Dimension(1050,660));
            scrpModelDraw.setViewportView(drawpanel);
            ModelDrawing.timer.setDelay(sldSpeed.getMaximum() - sldSpeed.getValue()+1);
            ModelDrawing.timer.stop();
    }//GEN-LAST:event_btnSwActionPerformed

    private void btnSummitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummitActionPerformed
        // TODO add your handling code here:
        Simulate();
    }//GEN-LAST:event_btnSummitActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        // TODO add your handling code here:
        StopSimulate();
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        // TODO add your handling code here:
        ContinueSimulate();
    }//GEN-LAST:event_btnContinueActionPerformed

    private void sldSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSpeedStateChanged
        // TODO add your handling code here:
            if(drawpanel != null)
                ModelDrawing.timer.setDelay(sldSpeed.getMaximum() - sldSpeed.getValue()+1);
                
    }//GEN-LAST:event_sldSpeedStateChanged

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        scrpModelDraw.setViewportView(null);
        lblClickedCommand.setText("");
        lblSpace1.setText(", $");
        lblSpace2.setText(", $");
        txtImed_beq.setVisible(false);
        txtImed_lw.setVisible(false);
        cboRS_lw.setVisible(false);
        cboRT.setVisible(true);
        cboRS.setVisible(true);
        resetProperties();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        if(drawpanel.lineNumber>0)
            drawpanel.lineNumber--;
        if(drawpanel != null)
            ModelDrawing.isBack = true;
        ModelDrawing.timer.start();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForwardActionPerformed
        // TODO add your handling code here:
        if(drawpanel.lineNumber < drawpanel.arrayLength-1)
            drawpanel.lineNumber++;
        if(drawpanel != null)
            ModelDrawing.isForward = true;
        ModelDrawing.timer.start();
    }//GEN-LAST:event_btnForwardActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        if(drawpanel != null)
        {   
            drawpanel.lineNumber = 0;
            ModelDrawing.isClear = true;
            ModelDrawing.timer.start();
        }
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void mnuiSimulateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiSimulateActionPerformed
        // TODO add your handling code here:
        Simulate();
    }//GEN-LAST:event_mnuiSimulateActionPerformed

    private void mnuiStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiStopActionPerformed
        // TODO add your handling code here:
        StopSimulate();
    }//GEN-LAST:event_mnuiStopActionPerformed

    private void mnuiContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiContinueActionPerformed
        // TODO add your handling code here:
        ContinueSimulate();
    }//GEN-LAST:event_mnuiContinueActionPerformed

    private void mnuiGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiGuideActionPerformed
        // TODO add your handling code here:
        GuideForm.StartGuideForm();
    }//GEN-LAST:event_mnuiGuideActionPerformed

    private void mnuiAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiAboutActionPerformed
        // TODO add your handling code here:
        AboutForm.StartAboutForm();
    }//GEN-LAST:event_mnuiAboutActionPerformed

    private void mnuiSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiSetupActionPerformed
        // TODO add your handling code here:
        SetupForm setup = new SetupForm();
        setup.StartSetupForm();
    }//GEN-LAST:event_mnuiSetupActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        WriteFile();
    }//GEN-LAST:event_formWindowClosing

    private void mnuiDatapathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiDatapathActionPerformed
        // TODO add your handling code here:
        Datapath.StartDatapath();
        this.dispose();
    }//GEN-LAST:event_mnuiDatapathActionPerformed

    private void mnuiPipelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiPipelineActionPerformed
        // TODO add your handling code here:
        Pipeline.StartPipeline();
        this.dispose();
    }//GEN-LAST:event_mnuiPipelineActionPerformed
    private void WriteFile()
    {
        File file = new File(inputlink);
        try {
            
        if(!file.exists())
        {
            File path = new File(System.getProperty("user.home")+File.separator + "Documents"+File.separator + "DatapathAndPipeline"+File.separator+"Datapath");
            path.mkdirs();
        }
        FileWriter writer = new FileWriter(file.getAbsolutePath());
        BufferedWriter bufwriter = new BufferedWriter(writer);
        switch(ModelDrawing.colorCrit) // Ghi Critical Color Line
        {
            case Black: bufwriter.write("CritColor = Black"); break;
            case Blue: bufwriter.write("CritColor = Blue"); break;
            case Cyan: bufwriter.write("CritColor = Cyan"); break;
            case Green: bufwriter.write("CritColor = Green"); break;
            case Gray: bufwriter.write("CritColor = Gray"); break;
            case LightGray: bufwriter.write("CritColor = LightGray"); break;
            case DarkGray: bufwriter.write("CritColor = DarkGray"); break;
            case Magenta: bufwriter.write("CritColor = Magenta"); break;
            case Orange: bufwriter.write("CritColor = Orange"); break;
            case Pink: bufwriter.write("CritColor = Pink"); break;
            case White: bufwriter.write("CritColor = White"); break;
            case Yellow: bufwriter.write("CritColor = Yellow"); break;
            default :
            case Red:
                bufwriter.write("CritColor = Red");break;
        }
        switch(ModelDrawing.colorIns)   //Ghi Instruction Color Line
        {
            case Black: bufwriter.newLine();bufwriter.write("InsColor = Black"); break;
            case Blue: bufwriter.newLine();bufwriter.write("InsColor = Blue"); break;
            case Red: bufwriter.newLine();bufwriter.write("InsColor = Red"); break;
            case Green: bufwriter.newLine();bufwriter.write("InsColor = Green"); break;
            case Gray: bufwriter.newLine();bufwriter.write("InsColor = Gray"); break;
            case LightGray: bufwriter.newLine();bufwriter.write("InsColor = LightGray"); break;
            case DarkGray: bufwriter.newLine();bufwriter.write("InsColor = DarkGray"); break;
            
            case Magenta: bufwriter.newLine();bufwriter.write("InsColor = Magenta"); break;
            case Orange: bufwriter.newLine();bufwriter.write("InsColor = Orange"); break;
            case Pink: bufwriter.newLine();bufwriter.write("InsColor = Pink"); break;
            case White: bufwriter.newLine();bufwriter.write("InsColor = White"); break;
            case Yellow: bufwriter.newLine();bufwriter.write("InsColor = Yellow"); break;
            default :
            case Cyan:
               bufwriter.newLine();  bufwriter.write("InsColor = Cyan"); break;
        }
        switch(ModelDrawing.colorUni)  //Ghi Unimportant Line Color
        {
            case Black: bufwriter.newLine();bufwriter.write("UniColor = Black"); break;
            case Blue: bufwriter.newLine();bufwriter.write("UniColor = Blue"); break;
            case Cyan: bufwriter.newLine();bufwriter.write("UniColor = Cyan"); break;
            case Green: bufwriter.newLine();bufwriter.write("UniColor = Green"); break;
            case Red: bufwriter.newLine();bufwriter.write("UniColor = Red"); break;
            case LightGray: bufwriter.newLine();bufwriter.write("UniColor = LightGray"); break;
            case DarkGray: bufwriter.newLine();bufwriter.write("UniColor = DarkGray"); break;
            
            case Magenta: bufwriter.newLine();bufwriter.write("UniColor = Magenta"); break;
            case Orange: bufwriter.newLine();bufwriter.write("UniColor = Orange"); break;
            case Pink: bufwriter.newLine();bufwriter.write("UniColor = Pink"); break;
            case White: bufwriter.newLine();bufwriter.write("UniColor = White"); break;
            case Yellow: bufwriter.newLine();bufwriter.write("UniColor = Yellow"); break;
            default :
            case Gray:
                bufwriter.newLine(); bufwriter.write("UniColor = Gray"); break;
        }
        bufwriter.newLine();
        bufwriter.write("Thickness = " +String.valueOf(ModelDrawing.thickness));  // Ghi độ dày
        
        if(ModelDrawing.renderhints.get(RenderingHints.KEY_ANTIALIASING) == RenderingHints.VALUE_ANTIALIAS_ON)   
            //Ghi Anti-Aliasing
        {
            bufwriter.newLine();
            bufwriter.write("Anti-Aliasing = true"); 
        }
        else
        {
            bufwriter.newLine();
            bufwriter.write("Anti-Aliasing = false"); 
        }
        
        if(ModelDrawing.renderhints.get(RenderingHints.KEY_RENDERING)== RenderingHints.VALUE_RENDER_DEFAULT)
        {
            bufwriter.newLine();
            bufwriter.write("Rendering = Default"); 
        }
        else if(ModelDrawing.renderhints.get(RenderingHints.KEY_RENDERING)== RenderingHints.VALUE_RENDER_QUALITY)
        {
            bufwriter.newLine();
            bufwriter.write("Rendering = Quality"); 
        }
        else if(ModelDrawing.renderhints.get(RenderingHints.KEY_RENDERING)== RenderingHints.VALUE_RENDER_SPEED)
        {
            bufwriter.newLine();
            bufwriter.write("Rendering = Speed"); 
        }
        
        bufwriter.close();
        writer.close();
        } catch (IOException ex) {
            WriteLog(ex);
        }
        
    }
    
    private void WriteLog(Exception e)
    {
         File filelog = new File(System.getProperty("user.home")+File.separator + "Documents"+File.separator + "DatapathAndPipeline"+File.separator+"Datapath"+File.separator+"buglog.txt");
        if(filelog.length()>10_485_760l)
            filelog.delete();
        if(!filelog.exists())
        {
            File path = new File(System.getProperty("user.home")+File.separator + "Documents"+File.separator + "DatapathAndPipeline"+File.separator+"Datapath");
            path.mkdirs();
        }
        try (FileWriter writerlog = new FileWriter(filelog.getAbsolutePath(),true)) {
            Calendar cal = new GregorianCalendar(TimeZone.getDefault(), Locale.UK);
            BufferedWriter bufwriterlog = new BufferedWriter(writerlog);
                String debug = cal.getTime().toString() + " " + e.toString();
                bufwriterlog.write(debug);
                bufwriterlog.newLine();
            bufwriterlog.close();
           
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Không ghi được file bug log", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    private boolean TransferCommand()
    {
        if(clicked == cmd.NONE){
            JOptionPane.showMessageDialog(null, "Chưa chọn lệnh thực thi nào\nHãy chọn một lệnh để thực thi","Lỗi",JOptionPane.OK_OPTION);
            return false;
        }
//Code cho xuat hien so nhi phan
        StringBuilder regStt = new StringBuilder("");
        int count =0;
        //Reset giá trị của binary
        binary = new StringBuilder("");
        if (clicked == cmd.ADD || clicked == cmd.OR || clicked == cmd.AND || clicked == cmd.SLT || clicked == cmd.SUB)
        {
            if(!cboRS.getSelectedItem().toString().equals("<choose>") && !cboRT.getSelectedItem().toString().equals("<choose>") && !cboRD.getSelectedItem().toString().equals("<choose>")){
                binary = binary.append("000000 ");
                binary = binary.append(regMap.get(cboRS.getSelectedItem())+" ");
                binary = binary.append(regMap.get(cboRT.getSelectedItem())+" ");
                binary = binary.append(regMap.get(cboRD.getSelectedItem())+" ");
                //Đưa vào trường shamt
                binary = binary.append("00000 ");
                //append vào function code của lệnh
                switch(clicked){
                    case ADD:
                        binary = binary.append("100000");
                        break;
                    case SUB:
                        binary = binary.append("100010");
                        break;
                    case AND:
                        binary = binary.append("100100");
                        break;
                    case OR:
                        binary = binary.append("100101");
                        break;
                    case SLT:
                        binary = binary.append("101010");
                        break;
                }
                txtBinary.setText(binary.toString());
            }
           else{
                //Kiểm tra các combo thanh ghi đều đã được chọn
                if(cboRS.getSelectedItem().equals("<choose>")){
                    regStt.append("rs");
                    count ++;
                }
                if(cboRT.getSelectedItem().equals("<choose>")){
                    if(count >0)
                        regStt.append(", ");
                    regStt.append("rt");
                    count++;
                }
                if(cboRD.getSelectedItem().equals("<choose>")){
                    if(count >0)
                        regStt.append(", ");
                    regStt.append("rd");
                }
                JOptionPane.showMessageDialog(null, "Chưa chọn thanh ghi "+regStt,"Lỗi",JOptionPane.OK_OPTION);
                return false;
            }
            txtBinary.setText(binary.toString());
            
        }
    //Trường hợp load word và store word và beq
        if(clicked == cmd.LW || clicked == cmd.SW||clicked==cmd.BEQ){
            //Reset giá trị của binary
            binary = new StringBuilder("");
            
            switch(clicked){
                case LW:
                    binary = binary.append("100011 ");
                    break;
                case SW:
                    binary = binary.append("101011 ");
                    break;
                case BEQ:
                    binary = binary.append("000100 ");
                    break;
            }
            /**
             * 
             * Kiểm tra text field người dùng nhập vào
             * txtImed_lw dùng cho cả lw và sw
             */
            String txt_temp;
            switch(clicked){
                case LW:case SW:
                    txt_temp = txtImed_lw.getText();
                    if (txt_temp.startsWith(" ")||txt_temp.equals("")){
                        JOptionPane.showMessageDialog(null, "Trường số Imediate không thể chứ ký tự khoảng trắng (space) hoặc để trống\nVui lòng chỉ nhập ký số.","Lỗi",JOptionPane.OK_OPTION);
                        return false;
                    }
                    break;
                case BEQ:
                    txt_temp = txtImed_beq.getText();
                    if (txt_temp.startsWith(" ")||txt_temp.equals("")){
                        JOptionPane.showMessageDialog(null, "Trường số Imediate không thể chứ ký tự khoảng trắng (space) hoặc để trống\nVui lòng chỉ nhập ký số.","Lỗi",JOptionPane.OK_OPTION);
                        return false;
                    }
                    break;
            }
            
            /**
             * 
             * Trong lw và sw, Dùng cboRD (R-format) thay cho cboRT (I-format)
             * Trong lệnh beq, Dùng cboRD (R-format) thay cho cboRS (I-format), cboRS (R-format) thay cho cboRT (I-format)
             * cboRS_lw dùng cho cả lw và sw
             */
            StringBuilder ImedInBin; //biến lưu giá trị nhị phân của số Imediate
            StringBuilder zero; //Biến lưu các số 0 phía trước để lập đủ 16 bits
            switch(clicked){
                case LW:case SW:
                    //Trường hợp cho lw và sw
                    if(!cboRS_lw.getSelectedItem().toString().equals("<choose>") && !cboRD.getSelectedItem().toString().equals("<choose>")){
                                binary = binary.append(regMap.get(cboRS_lw.getSelectedItem())+" "); //Lưu nhị phân của RS
                                binary = binary.append(regMap.get(cboRD.getSelectedItem())+" "); //Lưu nhị phân của RT
                    }
                    else{
                        regStt = new StringBuilder("");
                        count =0;
                        if(cboRS_lw.getSelectedItem().equals("<choose>")){
                            regStt.append("rs");
                            count ++;
                        }
                        if(cboRD.getSelectedItem().equals("<choose>")){ //Trong lw dùng lại RD thay cho RT
                            if(count >0)
                                regStt.append(", ");
                            regStt.append("rt");
                            count++;
                        }
                        JOptionPane.showMessageDialog(null, "Chưa chọn thanh ghi "+regStt,"Lỗi",JOptionPane.OK_OPTION);
                        return false;
                    }
                    break;
                case BEQ:
                    //Trường hợp cho beq
                    if(!cboRD.getSelectedItem().equals("<choose>") && !cboRS.getSelectedItem().equals("<choose>")){
                           //Lưu nhị phân RS
                           binary = binary.append(regMap.get(cboRD.getSelectedItem())+" ");
                           //Lưu nhị phân RT
                           binary = binary.append(regMap.get(cboRS.getSelectedItem())+" ");
                       }
                    else{
                       regStt = new StringBuilder("");
                       count =0;
                       if(cboRD.getSelectedItem().equals("<choose>")){
                           regStt.append("rs");
                           count++;
                       }
                       if(cboRS.getSelectedItem().equals("<choose>")){
                           if(count>0)
                               regStt.append(", ");
                           regStt.append("rt");
                           count++;
                       }
                       JOptionPane.showMessageDialog(null, "Chưa chọn thanh ghi "+regStt,"Lỗi",JOptionPane.OK_OPTION);
                       return false;
                    }
                    break;
            }
            
            //Tạo biến và chuyển số Imed sang số nhị phân 16 bits
            //Chuyển giá trị của txtImed_lw về số sau đó chuyển sang nhị phân
            String temp_Imediate;
            if(clicked == cmd.LW || clicked==cmd.SW)
                temp_Imediate = txtImed_lw.getText();
            else
                temp_Imediate = txtImed_beq.getText();
            ImedInBin = new StringBuilder(Integer.toBinaryString(Integer.parseInt(temp_Imediate)));
            //Thêm số 0 vào phía trước để đủ 16 bits
            zero = new StringBuilder(""); //Lưu các số 0 phía trước ImedInBin
            for(int i=0;i<16-ImedInBin.length();i++){
                zero.append("0");
            }
            //Nối ImedInBin vào sau dãy số 0
            zero.append(ImedInBin);
            //Nối chuỗi có số 0 và ImedInBin vào chuỗi binary để đưa ra txtBinary
            binary = binary.append(zero);
            //Hiển thị lên txtBinary
            txtBinary.setText(binary.toString());
        }
        
//Code day so hexa
        int i =0; //Biến lưu vị trí của số cần tách lấy 4 số
        int j=0;
        hexa = new StringBuilder("0x");
        //Xóa khoảng trắng trong chuỗi hiển thị binary
        while(j<binary.length()){
            if(binary.charAt(j)==' '){
                binary.deleteCharAt(j);
            }
            j++;
        }
        
        StringBuilder str4bits = new StringBuilder(binary.toString());
        while(i<binary.toString().length()){
            hexa = hexa.append(Integer.toHexString(Integer.parseInt(str4bits.substring(i, i+4),2)));
            i+=4;
        }
        txtHexa.setText(hexa.toString());
        return true;
    }
    
    private void resetProperties(){
        clicked = cmd.NONE;
        cboRD.setSelectedItem("<choose>");
        cboRS.setSelectedItem("<choose>");
        cboRS_lw.setSelectedItem("<choose>");
        cboRT.setSelectedItem("<choose>");
        
        txtBinary.setText("");
        txtHexa.setText("");
        txtImed_beq.setText("");
        txtImed_lw.setText("");
        rdoEqual.setEnabled(false);
        mnuiSetup.setEnabled(true);
        btnSummit.setEnabled(true);
        btnBack.setEnabled(false);
        btnForward.setEnabled(false);
        btnPause.setEnabled(false);
        btnContinue.setEnabled(false);
        mnuiSimulate.setEnabled(true);
        mnuiContinue.setEnabled(false);
        mnuiStop.setEnabled(false);
    }
    /**
     */
    
    public static void StartDatapath() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Datapath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datapath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datapath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datapath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Datapath().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAnd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBeq;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnForward;
    private javax.swing.JButton btnLw;
    private javax.swing.JButton btnOr;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSlt;
    private javax.swing.JButton btnSub;
    private javax.swing.JButton btnSummit;
    private javax.swing.JButton btnSw;
    private javax.swing.JComboBox<String> cboRD;
    private javax.swing.JComboBox<String> cboRS;
    private javax.swing.JComboBox<String> cboRT;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbSpeed;
    private javax.swing.JLabel lblBinary;
    private javax.swing.JLabel lblClickedCommand;
    private javax.swing.JLabel lblHexa;
    private javax.swing.JLabel lblSpace1;
    private javax.swing.JLabel lblSpace2;
    private javax.swing.JMenuBar mnbar;
    private javax.swing.JMenu mnuCheDo;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuTrangThai;
    private javax.swing.JMenuItem mnuiAbout;
    private javax.swing.JMenuItem mnuiContinue;
    private javax.swing.JMenuItem mnuiDatapath;
    private javax.swing.JMenuItem mnuiGuide;
    private javax.swing.JMenuItem mnuiPipeline;
    private javax.swing.JMenuItem mnuiSetup;
    private javax.swing.JMenuItem mnuiSimulate;
    private javax.swing.JMenuItem mnuiStop;
    private javax.swing.JPanel pnlClickedButton;
    private javax.swing.JPanel pnlCommand;
    private javax.swing.JRadioButton rdoEqual;
    private javax.swing.JScrollPane scrpModelDraw;
    private javax.swing.JSlider sldSpeed;
    private javax.swing.JTextField txtBinary;
    private javax.swing.JTextField txtHexa;
    // End of variables declaration//GEN-END:variables
    //private javax.swing.JTextField txtImed_beq;
    private enum cmd {
        ADD,SUB,OR,AND,SLT,SW,LW,BEQ,NONE;
    }
    cmd clicked;
    private javax.swing.JLabel lblParentheses_1;
    private javax.swing.JLabel lblParentheses_2;
    private javax.swing.JTextField txtImed_beq;
    private javax.swing.JTextField txtImed_lw;
    private javax.swing.JLabel lblSpace_lw1;
    private javax.swing.JComboBox<String> cboRS_lw;
    private ModelDrawing drawpanel;
    private StringBuilder binary;
    private StringBuilder hexa;
    private Map<String,String> regMap;
    //
}
