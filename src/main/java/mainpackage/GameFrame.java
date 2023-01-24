/*No-Name
6313139 Ruttiyaporn Kongtrakul 
6313141 Vatcharapong Laklaem
6313174 Natthabodi Bochol
6213202 Nitipoom Soomsakit*/
package mainpackage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.event.*;
import javax.sound.sampled.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

import mainpackage.Game.LevelHandler;

public class GameFrame extends window{
    protected JFrame    LevelWindow,GameMenuWindow, SelectedWindow, VictoryWindow;
    protected JPanel    LevelPanel, SelectedPanel, TypePanel, ExtraPanel;
    protected JPanel    OnePanel;
    protected JPanel    TwoPanel;
    protected JPanel    ThreePanel;
    protected JPanel    FourPanel;
    protected JPanel    FivePanel;
    protected JPanel    SixPanel;
    private JLabel      LevelDraw, SelectedDraw, ExtraDraw;
    private JLabel      OneDraw,TwoDraw,ThreeDraw,FourDraw,FiveDraw,SixDraw;
    private JLabel      FlowerDraw,CakeDraw,ManuesDraw,PolaroidDraw,IUDraw,ViewSunDraw;
    private MyImageIcon LevelBG, GameBG, SelectedBG, FlowerS, CakeS, ManueS, PolaroidS, IuS, ViewSunS;
    private MyButton    Level_ONE_Button,Level_TWO_Button,Level_THREE_Button,Level_FOUR_Button,Level_FIVE_Button,Level_SIX_Button;
    private MyButton    BackButton, PauseButton;
    protected Container con;
    protected JRadioButton A1, A2, A3, A4, A5, A6, A7, A8;
    protected int   A1check = 0, A2check = 0, A3check = 0, A4check = 0, A5check = 0, A6check = 0, A7check = 0, A8check = 0;
    
    private MySound     GameThemeSong;
    protected boolean   pause, checkRadio;
    protected int       checkR;
    private int         frameWidth = 1280, frameHeight = 720; 
    private int         OneBlockWidth = 200, OneBlockHeight = 120;
    
    PlayerSaved         player = new PlayerSaved();
    private String      Name, Avatar;
    private int         Level;
    public int          tempLevel;
    
    Answer  answer = new Answer();
    
    public void setGameplayer(PlayerSaved p){
        player = p;
        Name = player.GetName();
        Avatar = player.GetAvatar();
        Level = player.GetLevel();
    }
    public String getnameplayer(){
        return Name;
    }
    public String getavatarplayer(){
        return Avatar;
    }
    public int getlevelplayer(){
        return Level;
    }
    public int gettemplevelplayer(){
        return tempLevel;
    }
    public void settemplevelplayer(int t){
        tempLevel = t;
    }
    
    public void createLevelFrame(LevelHandler lHandler){
        
        LevelWindow = new JFrame();
        LevelWindow.setTitle(" LEVEL MAP ");
        LevelWindow.setSize(frameWidth,760);
        LevelWindow.setLocationRelativeTo(null);
        LevelWindow.getContentPane().setBackground(Color.black);
        LevelWindow.setResizable(false);
        LevelWindow.setLayout(null);
        LevelWindow.setVisible(true);
        LevelWindow.setAlwaysOnTop(true);
        LevelWindow.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        
        LevelPanel = new JPanel();
        
        LevelPanel.setBounds(0, 0, frameWidth, frameHeight);
        LevelPanel.setBackground( Color.BLACK );
	LevelPanel.setLayout( new BorderLayout() );
        
        LevelBG = new MyImageIcon("levelUI/LEVELMAP_BG.png").resize(frameWidth, frameHeight);
        
        LevelDraw = new JLabel();
        LevelDraw.setIcon(LevelBG);
        LevelDraw.setLayout(null);
        
        SelectedPanel = new JPanel();
        SelectedPanel.setBounds(0, 0, frameWidth, frameHeight);
        SelectedPanel.setBackground( Color.BLACK );
	SelectedPanel.setLayout( new BorderLayout() );
        SelectedPanel.setVisible(false);
        
        Level_ONE_Button = new MyButton("levelUI/1.png","levelUI/1click.png",110,180,"slevel");
        LevelDraw.add(Level_ONE_Button);
        Level_ONE_Button.addActionListener(lHandler);
        Level_ONE_Button.setActionCommand("Level_ONE");
        
        Level_TWO_Button = new MyButton("levelUI/2.png","levelUI/2click.png",330,180,"slevel");
        LevelDraw.add(Level_TWO_Button);
        Level_TWO_Button.addActionListener(lHandler);
        Level_TWO_Button.setActionCommand("Level_TWO");
        
        Level_THREE_Button = new MyButton("levelUI/3.png","levelUI/3click.png",550,150,"blevel");
        LevelDraw.add(Level_THREE_Button);
        Level_THREE_Button.addActionListener(lHandler);
        Level_THREE_Button.setActionCommand("Level_THREE");
        
        Level_FOUR_Button = new MyButton("levelUI/4.png","levelUI/4click.png",510,430,"slevel");
        LevelDraw.add(Level_FOUR_Button);
        Level_FOUR_Button.addActionListener(lHandler);
        Level_FOUR_Button.setActionCommand("Level_FOUR");
        
        Level_FIVE_Button = new MyButton("levelUI/5.png","levelUI/5click.png",730,430,"slevel");
        LevelDraw.add(Level_FIVE_Button);
        Level_FIVE_Button.addActionListener(lHandler);
        Level_FIVE_Button.setActionCommand("Level_FIVE");
        
        Level_SIX_Button = new MyButton("levelUI/6.png","levelUI/6click.png",950,400,"blevel");
        LevelDraw.add(Level_SIX_Button);
        Level_SIX_Button.addActionListener(lHandler);
        Level_SIX_Button.setActionCommand("Level_SIX");
        
        BackButton = new MyButton("levelUI/BACK_OFF.png","levelUI/BACK_ON.png",60,580, "half");//
        LevelDraw.add(BackButton);
        BackButton.addActionListener(lHandler);
        BackButton.setActionCommand("back");
        BackButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                LevelWindow.dispose();
            }
        });
        
        Level_TWO_Button.setEnabled(false);
        Level_THREE_Button.setEnabled(false);
        Level_FOUR_Button.setEnabled(false);
        Level_FIVE_Button.setEnabled(false);
        Level_SIX_Button.setEnabled(false);
        
        System.out.println(getlevelplayer());
        if(getlevelplayer()==2){
            Level_TWO_Button.setEnabled(true);
        }if(getlevelplayer()==3){
            Level_THREE_Button.setEnabled(true);
            Level_TWO_Button.setEnabled(true);
        }if(getlevelplayer()==4){
            Level_FOUR_Button.setEnabled(true);
            Level_THREE_Button.setEnabled(true);
            Level_TWO_Button.setEnabled(true);
        }if(getlevelplayer()==5){
            Level_FIVE_Button.setEnabled(true);
            Level_FOUR_Button.setEnabled(true);
            Level_THREE_Button.setEnabled(true);
            Level_TWO_Button.setEnabled(true);
        }if(getlevelplayer()==6){
            Level_SIX_Button.setEnabled(true);
            Level_FIVE_Button.setEnabled(true);
            Level_FOUR_Button.setEnabled(true);
            Level_THREE_Button.setEnabled(true);
            Level_TWO_Button.setEnabled(true);
        }
        
        LevelPanel.add(LevelDraw, BorderLayout.CENTER);
        LevelWindow.add(LevelPanel);
        LevelWindow.validate();
        
    }
    
    public void createSelected(){
        checkR = 0;
        int check = 0;
        
        SelectedWindow = new JFrame();
        SelectedWindow.setTitle(" SPEED PUZZLE MODE ");
        SelectedWindow.setSize(frameWidth,760);
        SelectedWindow.setLocationRelativeTo(null);
        SelectedWindow.getContentPane().setBackground(Color.black);
        SelectedWindow.setResizable(false);
        SelectedWindow.setLayout(null);
        SelectedWindow.setVisible(true);
        SelectedWindow.setAlwaysOnTop(true);
        SelectedWindow.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        //LevelWindow.repaint();
        
        SelectedPanel = new JPanel();
        SelectedPanel.setBounds(0, 0, frameWidth, frameHeight);
        SelectedPanel.setBackground( Color.BLACK );
	SelectedPanel.setLayout( new BorderLayout() );
        
        SelectedBG = new MyImageIcon("GameUI/selectBG.png").resize(frameWidth, frameHeight);
        SelectedDraw = new JLabel();
        SelectedDraw.setIcon(SelectedBG);
        SelectedDraw.setLayout(null);
        
        FlowerS        = new MyImageIcon("GameUI/flower.png").resize(OneBlockWidth, OneBlockHeight);
        FlowerDraw     = new JLabel();
        FlowerDraw.setIcon(FlowerS);
        FlowerDraw.setLayout(null);
        FlowerDraw.setBounds(240, 90, OneBlockWidth, OneBlockHeight+20);
        A1 = new JRadioButton("Flower");   
        A1.setBounds(240, 90, OneBlockWidth, 20);
        A1.setActionCommand("Flower");
        getIsSelect(A1, SelectedWindow);
        
        SelectedDraw.add(A1);
        SelectedDraw.add(FlowerDraw);
        
        CakeS        = new MyImageIcon("GameUI/cake.png").resize(OneBlockWidth, OneBlockHeight);
        CakeDraw     = new JLabel();
        CakeDraw.setIcon(CakeS);
        CakeDraw.setLayout(null);
        CakeDraw.setBounds(480, 90, OneBlockWidth, OneBlockHeight+20);
        A2 = new JRadioButton("Cake");
        A2.setBounds(480, 90, OneBlockWidth, 20);
        A2.setActionCommand("Cake");
        getIsSelect(A2, SelectedWindow);
        
        SelectedDraw.add(A2);
        SelectedDraw.add(CakeDraw);
        
        ManueS        = new MyImageIcon("GameUI/chae.png").resize(OneBlockWidth, OneBlockHeight);
        ManuesDraw     = new JLabel();
        ManuesDraw.setIcon(ManueS);
        ManuesDraw.setLayout(null);
        ManuesDraw.setBounds(720, 360, OneBlockWidth, OneBlockHeight+20);
        A3 = new JRadioButton("Manues");
        A3.setBounds(720, 360, OneBlockWidth, 20);
        A3.setActionCommand("Manues");
        getIsSelect(A3, SelectedWindow);
        
        SelectedDraw.add(A3);
        SelectedDraw.add(ManuesDraw);
        
        PolaroidS       = new MyImageIcon("GameUI/polaroid.png").resize(OneBlockWidth, OneBlockHeight);
        PolaroidDraw    = new JLabel();
        PolaroidDraw.setIcon(PolaroidS);
        PolaroidDraw.setLayout(null);
        PolaroidDraw.setBounds(720, 90, OneBlockWidth, OneBlockHeight+20);
        A4 = new JRadioButton("Polaroid");
        A4.setBounds(720, 90, OneBlockWidth, 20);
        A4.setActionCommand("Polaroid");
        getIsSelect(A4, SelectedWindow);

        
        SelectedDraw.add(A4);
        SelectedDraw.add(PolaroidDraw);
        
        IuS   = new MyImageIcon("GameUI/iu1.png").resize(OneBlockWidth, OneBlockHeight);
        IUDraw= new JLabel();
        IUDraw.setIcon(IuS);
        IUDraw.setLayout(null);
        IUDraw.setBounds(240, 360, OneBlockWidth, OneBlockHeight+20);
        A5 = new JRadioButton("IU");
        A5.setBounds(240, 360, OneBlockWidth, 20);
        A5.setActionCommand("IU");
        getIsSelect(A5, SelectedWindow);
        
        SelectedDraw.add(A5);
        SelectedDraw.add(IUDraw);
        
        ViewSunS     = new MyImageIcon("GameUI/view1.png").resize(OneBlockWidth, OneBlockHeight);
        ViewSunDraw  = new JLabel();
        ViewSunDraw.setIcon(ViewSunS);
        ViewSunDraw.setLayout(null);
        ViewSunDraw.setBounds(480, 360, OneBlockWidth, OneBlockHeight+20);
        A6 = new JRadioButton("Viewsun");
        A6.setBounds(480, 360, OneBlockWidth, 20);
        A6.setActionCommand("Viewsun");
        getIsSelect(A6, SelectedWindow);
        
        SelectedDraw.add(A6);
        SelectedDraw.add(ViewSunDraw);
        
        MyButton B = new MyButton("GameUI/back.png","GameUI/backclick.png",40,630, "game");
        SelectedDraw.add(B);
        B.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                //SelectedDraw.setVisible(false);
                //SelectedDraw.remove(B);
                SelectedWindow.dispose();
                //LevelWindow.dispose();
            }
	});
        
        MyButton StartB = new MyButton("GameUI/start.png","GameUI/startclick.png",1080,630, "game");
        SelectedDraw.add(StartB);
        StartB.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                //SelectedWindow.dispose();
                if(A1check==1){
                    A1check=0;
                    createMode("flowerey");
                }else if(A2check==1){
                    A2check=0;
                    createMode("cakey");
                }else if(A3check==1){
                    A3check=0;
                    createMode("polaroided");
                }else if(A4check==1){
                    A4check=0;
                    createMode("iupuz");
                }else if(A5check==1){
                    A5check=0;
                    createMode("viewsun");
                }else if(A6check==1){
                    A6check=0;
                    createMode("chae");
                }
                    
            }
	});

        SelectedPanel.add(SelectedDraw, BorderLayout.CENTER);
        SelectedWindow.add(SelectedPanel);
        SelectedWindow.validate();
    }
    
    public void getIsSelect (JRadioButton A, JFrame f){
        
        A.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) { 
            boolean state = A.isSelected();
            //
            if(state){
                switch(e.getActionCommand()){
                case "Flower" : A1check = 1; break;
                case "Cake" : A2check = 1; break;
                case "Polaroid" : A3check = 1; break;
                case "IU" : A4check = 1; break;
                case "Viewsun" : A5check = 1; break;
                case "Manues" : A6check = 1; break;
                }

               System.out.println(A.getActionCommand() +" is selected.");
               checkR++;
            } else {
                switch(e.getActionCommand()){
                case "Flower" : A1check = 0; break;
                case "Cake" : A2check = 0; break;
                case "Polaroid" : A3check = 0; break;
                case "IU" : A4check = 0; break;
                case "Viewsun" : A5check = 0; break;
                case "Manues" : A6check = 0; break;
                }
               System.out.println(A.getActionCommand() +" is not selected.");
               checkR--;
            }
            System.out.println(checkR + " has been selected");
            if(checkR>1){
                A.setSelected(false);  
                JOptionPane.showMessageDialog(f,"You can select only 1 map at the time ","Alert",JOptionPane.WARNING_MESSAGE);    
                checkR=1;
            }
          }
        });
    }
    
     public void createMode(String f){
         

            class Clock 
            {
                static int time;
                class Task extends TimerTask
                {
                    public void run()
                        {
                            System.out.println(time);
                            if(time<1) {
                                Clock.stop();
                                JOptionPane.showMessageDialog(SelectedWindow,"Time out!! try again next time","Alert",JOptionPane.WARNING_MESSAGE);
                                SelectedWindow.dispose();
                            }
                            
                            time--;
                        }
                    public int getTime(){ return time;}
                }
                private static Timer timer;
                public Clock(int sec)
                {
                    time = sec;
                }
                public void countdown()
                {
                    timer = new Timer();
                    TimerTask task = new Task();
                    timer.schedule(task,0,1000);
                }

                //public int getTime(){ return time;}
                public static void stop(){ timer.cancel();}
                }
            
        //SelectedPanel.setVisible(false);
        SelectedPanel.setVisible(false);
        SelectedWindow.setVisible(true);
        SelectedWindow.repaint();
        
        //SelectedWindow.setTitle(countdwn(timer));
        Clock clock;
        clock = new Clock(90);
        clock.countdown();
        ///con = SelectedWindow.getContentPane();
        
        ExtraPanel = new JPanel();
        ExtraPanel.setBounds(0, 0, frameWidth, frameHeight);
        ExtraPanel.setBackground( Color.BLACK );
	ExtraPanel.setLayout( new BorderLayout() );
        ExtraPanel.setVisible(true);
        
        Random rn = new Random();
        int random = rn.nextInt(6) + 1;
        System.out.println(random);
        MyPuzzle P9 = new MyPuzzle(f+"/9.jpg",60,random*40,9);
        MyPuzzle P1 = new MyPuzzle(f+"/1.jpg",1100,random*40,1);
        MyPuzzle P7 = new MyPuzzle(f+"/7.jpg",60,random*60,7);
        MyPuzzle P3 = new MyPuzzle(f+"/3.jpg",1100,random*60,3);
        MyPuzzle P5 = new MyPuzzle(f+"/5.jpg",60,random*40,5);
        MyPuzzle P6 = new MyPuzzle(f+"/6.jpg",1100,random*45,6);
        MyPuzzle P2 = new MyPuzzle(f+"/2.jpg",65,random*45,2);
        MyPuzzle P8 = new MyPuzzle(f+"/8.jpg",1100,random*45,8);
        MyPuzzle P4 = new MyPuzzle(f+"/4.jpg",1105,random*45,4);
        MyPuzzle P10 = new MyPuzzle(f+"/10.jpg",65,random*40,10);
        MyPuzzle P11 = new MyPuzzle(f+"/11.jpg",65,random*50,11);
        MyPuzzle P12 = new MyPuzzle(f+"/12.jpg",1100,random*45,12);
        MyPuzzle P13 = new MyPuzzle(f+"/13.jpg",65,random*60,13);
        MyPuzzle P14 = new MyPuzzle(f+"/14.jpg",1105,random*40,14);
        MyPuzzle P15 = new MyPuzzle(f+"/15.jpg",65,random*40,15);
        
        
        GameBG = new MyImageIcon("GameUI/speed.png").resize(frameWidth, frameHeight);
        ExtraDraw = new JLabel();
        ExtraDraw.setIcon(GameBG);
        ExtraDraw.setLayout(null);
        
        
        int[] arrayshuffle = new int[16];
        for(int shuffle=1;shuffle<=15;shuffle++)
        {
             random = rn.nextInt(15) + 1;
             arrayshuffle[shuffle]=random;
             for(int i=1; i<shuffle;i++)
             {
                 while(arrayshuffle[shuffle]==arrayshuffle[i])
                 {
                     arrayshuffle[shuffle]=rn.nextInt(15) + 1;
                     System.out.printf("%d change %d\n",arrayshuffle[i],arrayshuffle[shuffle]);
                     i=0;
                 }
             }
             System.out.printf("%d = %d\n",shuffle,arrayshuffle[shuffle]);
             switch(arrayshuffle[shuffle])
             {
                    case 1 : ExtraDraw.add(P1); break;
                    case 2 : ExtraDraw.add(P2); break;
                    case 3 : ExtraDraw.add(P3); break;
                    case 4 : ExtraDraw.add(P4); break;
                    case 5 : ExtraDraw.add(P5); break;
                    case 6 : ExtraDraw.add(P6); break;
                    case 7 : ExtraDraw.add(P7); break;
                    case 8 : ExtraDraw.add(P8); break;
                    case 9 : ExtraDraw.add(P9); break;
                    case 10 : ExtraDraw.add(P10); break;
                    case 11 : ExtraDraw.add(P11); break;
                    case 12 : ExtraDraw.add(P12); break;
                    case 13 : ExtraDraw.add(P13); break;
                    case 14 : ExtraDraw.add(P14); break;
                    case 15 : ExtraDraw.add(P15); break;
             }
        }
        
        JButton c = new JButton("CONFIRM");
                c.setEnabled(true);
        c.setBounds(590, 640, 100, 40);
        c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int i1 = P1.getExtraintersect();
                int i2 = P2.getExtraintersect();
                int i3 = P3.getExtraintersect();
                int i4 = P4.getExtraintersect();
                int i5 = P5.getExtraintersect();
                int i6 = P6.getExtraintersect();
                int i7 = P7.getExtraintersect();
                int i8 = P8.getExtraintersect();
                int i9 = P9.getExtraintersect();
                int i10 = P10.getExtraintersect();
                int i11 = P11.getExtraintersect();
                int i12 = P12.getExtraintersect();
                int i13 = P13.getExtraintersect();
                int i14 = P14.getExtraintersect();
                int i15 = P15.getExtraintersect();
                
                int checkIntersect = i1+i2+i3+i4+i5+i6+i7+i8+i9+i10+i11+i12+i13+i14+i15;
                System.out.println("check intersect : "+ checkIntersect);
                
                if(checkIntersect == 15){
                     VictoryGame(tempLevel,ExtraDraw,ExtraPanel); 
                }else{
                    JOptionPane.showMessageDialog(SelectedWindow,"Please fill all picture in correct position first","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        ExtraDraw.add(c);
        //PauseGame(ExtraDraw,ExtraPanel);
        //clock.stop();
        //VictoryGame(tempLevel,OneDraw,OnePanel);
        
        ExtraPanel.add(ExtraDraw, BorderLayout.CENTER);
        SelectedWindow.add(ExtraPanel);
        SelectedWindow.validate();
    }



    public void setGame(){
        
        Random rn = new Random();
        int random = rn.nextInt(6) + 1;
        System.out.println(random);
        
        String f = " ";
        MyPuzzle P1 = new MyPuzzle(f+"/1.jpg",60,random*40,1);
        MyPuzzle P2 = new MyPuzzle(f+"/2.jpg",65,random*45,2);
        MyPuzzle P3 = new MyPuzzle(f+"/3.jpg",60,random*60,3);
        MyPuzzle P4 = new MyPuzzle(f+"/4.jpg",65,random*45,4);
        MyPuzzle P5 = new MyPuzzle(f+"/5.jpg",60,random*40,5);
        MyPuzzle P6 = new MyPuzzle(f+"/6.jpg",65,random*45,6);
        MyPuzzle P7 = new MyPuzzle(f+"/7.jpg",60,random*60,7);
        MyPuzzle P8 = new MyPuzzle(f+"/8.jpg",65,random*45,8);
        MyPuzzle P9 = new MyPuzzle(f+"/9.jpg",60,random*40,9);
        MyPuzzle D1 = new MyPuzzle(f+"/10.jpg",60,random*80,11);
        MyPuzzle D2 = new MyPuzzle(f+"/11.jpg",65,random*80,22);
        MyPuzzle D3 = new MyPuzzle(f+"/12.jpg",60,random*70,33);
        MyPuzzle D4 = new MyPuzzle(f+"/13.jpg",65,random*75,44);
        MyPuzzle D5 = new MyPuzzle(f+"/14.jpg",60,random*80,55);
        MyPuzzle D6 = new MyPuzzle(f+"/15.jpg",65,random*75,66);
    }
    
    public void PauseGame(JLabel Draw, JPanel Panel){
        
        PauseButton = new MyButton("GameUI/pause.png","GameUI/pause.png",1200,10, "pause");
        Draw.add(PauseButton);
        PauseButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                GameMenuUI(Draw,Panel);
            }
        });
    }
    
  public void goToLevel(int t){
        int temp = t;
        
        if(t == 1){
            createLevelONE("level1");
        }else if(temp == 2){
            createLevelTWO("Level2");
        }else if(temp == 3){
            createLevelTHREE("Level3");
        }else if(temp == 4){
            createLevelFOUR("Level4");
        }else if(temp == 5){
            createLevelFIVE("Level5");
        }else if(temp == 6){
            createLevelSIX("Level6");
        }
        
    }
  
   public void goToReset(JPanel Panel,int t){
        int temp = t;
        Panel.setVisible(true);
        if(t == 1){
            createLevelONE("Level1");
        }else if(temp == 2){
            createLevelTWO("Level2");
        }else if(temp == 3){
            createLevelTHREE("Leve3");
        }else if(temp == 4){
            createLevelFOUR("Level4");
        }else if(temp == 5){
            createLevelFIVE("Level5");
        }else if(temp == 6){
            createLevelSIX("Level6");
        }
        
    }
    
    public void VictoryGame(int t, JLabel Draw, JPanel Panel){
        
        if(getlevelplayer() <= t+1){
            player.SetLevel(t+1);
            player.printFile();
        }
        VictoryWindow = new JFrame();
        VictoryWindow.setTitle("Victory");
        VictoryWindow.setSize(640,360);
        VictoryWindow.setLocationRelativeTo(null);
        VictoryWindow.getContentPane().setBackground(Color.black);
        VictoryWindow.setResizable(false);
        VictoryWindow.setLayout(null);
        VictoryWindow.setVisible(true);
        VictoryWindow.setAlwaysOnTop(true);
        VictoryWindow.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        
        JPanel VictoryPanel;
        JLabel VictoryDraw;
        
       
        VictoryPanel = new JPanel();
        VictoryPanel.setBounds(0, 0, 640,360);
        VictoryPanel.setBackground( Color.BLACK );
	VictoryPanel.setLayout( new BorderLayout() );
        
        switch(t)
        {
            case 1 : Level_TWO_Button.setEnabled(true);break;
            case 2 : Level_THREE_Button.setEnabled(true);break;
            case 3 : Level_FOUR_Button.setEnabled(true);break;
            case 4 : Level_FIVE_Button.setEnabled(true);break;
            case 5 : Level_SIX_Button.setEnabled(true);break;
        }
        
        MyImageIcon VictoryBG = new MyImageIcon("endgame/winbg.png").resize(640,360);
        VictoryDraw = new JLabel();
        VictoryDraw.setIcon(VictoryBG);
        VictoryDraw.setLayout(null);
        

        MyButton NextLevelB = new MyButton("endgame/nextlevel.png","endgame/nextlevelclick.png",120,225,"endgame");
        VictoryDraw.add(NextLevelB);
        NextLevelB.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                //System.out.printf(">>> %d\n", tempLevel);
                goToLevel(t+1);
                Panel.setVisible(false);
                VictoryWindow.dispose();
            }
            
        });
        
        
        MyButton LeaveMapB = new MyButton("endgame/leavemap.png","endgame/leavemapclick.png",360,225,"endgame");
        VictoryDraw.add(LeaveMapB);
        LeaveMapB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //VictoryGame();
                VictoryWindow.dispose();
                Panel.setVisible(false);
                LevelPanel.setVisible(true);
                LevelWindow.setTitle(" LEVEL MAP ");
            }
            
        });
        
        VictoryPanel.add(VictoryDraw, BorderLayout.CENTER);
        VictoryWindow.add(VictoryPanel);
        
        VictoryWindow.validate();
        
    }
    
    public void GameMenuUI(JLabel Draw, JPanel Panel){
        GameMenuWindow = new JFrame();
        GameMenuWindow.setTitle("PAUSE");
        GameMenuWindow.setSize(210,210);
        GameMenuWindow.setLocationRelativeTo(null);
        GameMenuWindow.getContentPane().setBackground(Color.black);
        GameMenuWindow.setResizable(false);
        GameMenuWindow.setLayout(null);
        GameMenuWindow.setVisible(true);
        GameMenuWindow.setAlwaysOnTop(true);
        GameMenuWindow.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        //Panel.setVisible(false);
        //Draw.setVisible(false);
        JPanel  GameMenuPanel;
        JLabel  GameMenuDraw;
        JButton ResumeB, RestartB, BackB;
        
        GameMenuPanel = new JPanel();
        GameMenuPanel.setBounds(0, 0, 210, 210);
        GameMenuPanel.setBackground( Color.WHITE );
	GameMenuPanel.setLayout( new BorderLayout() );
        //GameMenuPanel.setBorder( new EmptyBorder(2,3,2,3));
        
        GameMenuDraw = new JLabel();
        GameMenuDraw.setLayout(null);
        
        ResumeB = new JButton("RESUME");
        ResumeB.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ){
                GameMenuWindow.dispose();
                //pause = true;
                
            }
	});
        RestartB = new JButton("RESTART");
        RestartB.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ){
                 GameMenuWindow.dispose();
                 goToReset(Panel,tempLevel);
                 Panel.setVisible(false);
               
            }
	});
        BackB = new JButton("BACK");
        BackB.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ){
                GameMenuWindow.dispose();
                Draw.remove(PauseButton);
                Panel.setVisible(false);                
                LevelPanel.setVisible(true);
                LevelWindow.setTitle(" LEVEL MAP ");
            }
	});
        
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(3, 3, 3, 3));
        JPanel btnPanel = new JPanel(new GridLayout(3, 1,0,4));
        
        btnPanel.add(ResumeB);
        btnPanel.add(RestartB);
        btnPanel.add(BackB);
        
        layout.add(btnPanel);
        GameMenuPanel.add(layout, BorderLayout.CENTER);
        
        GameMenuWindow.add(GameMenuPanel);
        //GameMenuWindow.setLocationByPlatform(true);
        GameMenuWindow.validate();
    }
    
    public void cleateStroyMode(String f, JLabel Draw, JPanel Panel, JFrame levelwin)
    {
        Random rn = new Random();
        int random = rn.nextInt(6) + 1;
        System.out.println(random);
        
        MyPuzzle P9 = new MyPuzzle(f+"/9.jpg",60,random*40,9);
        MyPuzzle P1 = new MyPuzzle(f+"/1.jpg",60,random*40,1);
        MyPuzzle P7 = new MyPuzzle(f+"/7.jpg",60,random*60,7);
        MyPuzzle P3 = new MyPuzzle(f+"/3.jpg",60,random*60,3);
        MyPuzzle P5 = new MyPuzzle(f+"/5.jpg",60,random*40,5);
        MyPuzzle P6 = new MyPuzzle(f+"/6.jpg",65,random*45,6);
        MyPuzzle P2 = new MyPuzzle(f+"/2.jpg",65,random*45,2);
        MyPuzzle P8 = new MyPuzzle(f+"/8.jpg",65,random*45,8);
        MyPuzzle P4 = new MyPuzzle(f+"/4.jpg",65,random*45,4);
        
        MyPuzzle D3 = new MyPuzzle(f+"/12.jpg",60,random*70,33);
        MyPuzzle D4 = new MyPuzzle(f+"/13.jpg",65,random*75,44);
        MyPuzzle D1 = new MyPuzzle(f+"/10.jpg",60,random*80,11);
        MyPuzzle D2 = new MyPuzzle(f+"/11.jpg",65,random*80,22);
        MyPuzzle D5 = new MyPuzzle(f+"/14.jpg",60,random*80,55);
        MyPuzzle D7 = new MyPuzzle(f+"/16.jpg",60,random*90,77);
        MyPuzzle D8 = new MyPuzzle(f+"/17.jpg",65,random*75,88);
        MyPuzzle D6 = new MyPuzzle(f+"/15.jpg",65,random*75,66);
        MyPuzzle D9 = new MyPuzzle(f+"/18.jpg",60,random*80,99);
        
        
        int[] arrayshuffle = new int[19];
        for(int shuffle=1;shuffle<=18;shuffle++)
        {
             random = rn.nextInt(18) + 1;
             arrayshuffle[shuffle]=random;
             for(int i=1; i<shuffle;i++)
             {
                 while(arrayshuffle[shuffle]==arrayshuffle[i])
                 {
                     arrayshuffle[shuffle]=rn.nextInt(18) + 1;
                     System.out.printf("%d change %d\n",arrayshuffle[i],arrayshuffle[shuffle]);
                     i=0;
                 }
             }
             System.out.printf("%d = %d\n",shuffle,arrayshuffle[shuffle]);
             switch(arrayshuffle[shuffle])
             {
                    case 1 : Draw.add(P1); break;
                    case 2 : Draw.add(P2); break;
                    case 3 : Draw.add(P3); break;
                    case 4 : Draw.add(P4); break;
                    case 5 : Draw.add(P5); break;
                    case 6 : Draw.add(P6); break;
                    case 7 : Draw.add(P7); break;
                    case 8 : Draw.add(P8); break;
                    case 9 : Draw.add(P9); break;
                    case 10 : Draw.add(D1); break;
                    case 11 : Draw.add(D2); break;
                    case 12 : Draw.add(D3); break;
                    case 13 : Draw.add(D4); break;
                    case 14 : Draw.add(D5); break;
                    case 15 : Draw.add(D6); break;
                    case 16 : Draw.add(D7); break;
                    case 17 : Draw.add(D8); break;
                    case 18 : Draw.add(D9); break;
             }
        }
        
        
        TypePanel = new JPanel();
        TypePanel.setBounds(800,640,300,40);
        TypePanel.setBackground(Color.black);
        TypePanel.setLayout(new GridLayout());
        
        JTextField  AnswerText;
        JButton c = new JButton("CONFIRM");
        AnswerText = new JTextField();
        AnswerText.setText("");
        TypePanel.add(AnswerText);
        con.add(TypePanel);
        //String s = NameText.getText();
        AnswerText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                
                String s = AnswerText.getText();
                answer.SetTempAnswer(s);
                System.out.println(s);
                char ch = e.getKeyChar();
                if(!(Character.isAlphabetic(ch) || (ch==KeyEvent.VK_BACK_SPACE) || ch==KeyEvent.VK_DELETE )) {
                 e.consume();
                }
                c.setEnabled(true);
                
            }
        });
        /*if(AnswerText.getText().isEmpty()){
            c.setEnabled(false);
        }else{
            c.setEnabled(true);
        }*///c.setEnabled(true);
        
        
        c.setBounds(1100, 640, 100, 40);
        c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int i1 = P1.getintersect();
                int i2 = P2.getintersect();
                int i3 = P3.getintersect();
                int i4 = P4.getintersect();
                int i5 = P5.getintersect();
                int i6 = P6.getintersect();
                int i7 = P7.getintersect();
                int i8 = P8.getintersect();
                int i9 = P9.getintersect();
                
                int d1 = D1.getintersect();
                int d2 = D2.getintersect();
                int d3 = D3.getintersect();
                int d4 = D4.getintersect();
                int d5 = D5.getintersect();
                int d6 = D6.getintersect();
                int d7 = D7.getintersect();
                int d8 = D8.getintersect();
                int d9 = D9.getintersect();
                int checkIntersect = i1+i2+i3+i4+i5+i6+i7+i8+i9+d1+d2+d3+d4+d5+d6+d7+d8+d9;
                System.out.println("check intersect : "+ checkIntersect);
                AnswerText.setText("");
                if(checkIntersect == 18){
                    answer.SetAnswer(AnswerText.getText());
                    System.out.println(answer.GetTempAnswer());
                    boolean checkA = answer.checkAnswer(answer.GetAnswer(), gettemplevelplayer());
                    //System.out.println("level "+player.GetLevel());
                    if(!checkA){
                        JOptionPane.showMessageDialog(levelwin,"Wrong Answer, TRY AGAIN","Alert",JOptionPane.WARNING_MESSAGE); 
                    }else{ 
                        VictoryGame(tempLevel,Draw,Panel); 
                        TypePanel.setVisible(false);
                        Panel.setVisible(false);
                        tempLevel++;
                    }
                }else{
                    JOptionPane.showMessageDialog(levelwin,"Please fill all picture in correct position first","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        Draw.add(c);
    }
   
    public void createLevelONE(String f){
        //SelectedPanel.setVisible(false);
        LevelPanel.setVisible(false);
        LevelWindow.setVisible(true);
        LevelWindow.repaint();
        LevelWindow.setTitle("LEVEL 1 :");
        
        con = LevelWindow.getContentPane();
        
        OnePanel = new JPanel();
        OnePanel.setBounds(0, 0, frameWidth, frameHeight);
        OnePanel.setBackground( Color.BLACK );
	OnePanel.setLayout( new BorderLayout() );
        OnePanel.setVisible(true);
        
        GameBG = new MyImageIcon("GameUI/gamemap.png").resize(frameWidth, frameHeight);
        OneDraw = new JLabel();
        OneDraw.setIcon(GameBG);
        OneDraw.setLayout(null);
        
        cleateStroyMode(f,OneDraw,OnePanel,LevelWindow);
        PauseGame(OneDraw,OnePanel);
        OnePanel.add(OneDraw, BorderLayout.CENTER);
        LevelWindow.add(OnePanel);
        LevelWindow.validate();       
    }
    
    
    
    public void createLevelTWO(String f){
        //SelectedPanel.setVisible(false);
        LevelPanel.setVisible(false);
        LevelWindow.setVisible(true);
        LevelWindow.repaint();
        LevelWindow.setTitle("LEVEL 2 :");
        
        con = LevelWindow.getContentPane();
        
        TwoPanel = new JPanel();
        TwoPanel.setBounds(0, 0, frameWidth, frameHeight);
        TwoPanel.setBackground( Color.BLACK );
	TwoPanel.setLayout( new BorderLayout() );
        TwoPanel.setVisible(true);
        
        GameBG = new MyImageIcon("GameUI/gamemap.png").resize(frameWidth, frameHeight);
        TwoDraw = new JLabel();
        TwoDraw.setIcon(GameBG);
        TwoDraw.setLayout(null);
        
        cleateStroyMode(f,TwoDraw,TwoPanel,LevelWindow);
        PauseGame(TwoDraw,TwoPanel);
        //VictoryGame(tempLevel,OneDraw,OnePanel);
        
        TwoPanel.add(TwoDraw, BorderLayout.CENTER);
        LevelWindow.add(TwoPanel);
        LevelWindow.validate();
    }
    
    public void createLevelTHREE(String f){
        //SelectedPanel.setVisible(false);
        LevelPanel.setVisible(false);
        LevelWindow.setVisible(true);
        LevelWindow.repaint();
        LevelWindow.setTitle("LEVEL 3 :");
        
        con = LevelWindow.getContentPane();
        
        ThreePanel = new JPanel();
        ThreePanel.setBounds(0, 0, frameWidth, frameHeight);
        ThreePanel.setBackground( Color.BLACK );
	ThreePanel.setLayout( new BorderLayout() );
        ThreePanel.setVisible(true);
        
        GameBG = new MyImageIcon("GameUI/gamemap.png").resize(frameWidth, frameHeight);
        ThreeDraw = new JLabel();
        ThreeDraw.setIcon(GameBG);
        ThreeDraw.setLayout(null);
        
        cleateStroyMode(f,ThreeDraw,ThreePanel,LevelWindow);
        PauseGame(ThreeDraw,ThreePanel);
        //VictoryGame(tempLevel,OneDraw,OnePanel);
        
        ThreePanel.add(ThreeDraw, BorderLayout.CENTER);
        LevelWindow.add(ThreePanel);
        LevelWindow.validate();
    }
    
    public void createLevelFOUR(String f){
        //SelectedPanel.setVisible(false);
        LevelPanel.setVisible(false);
        LevelWindow.setVisible(true);
        LevelWindow.repaint();
        LevelWindow.setTitle("LEVEL 4 :");
        
        con = LevelWindow.getContentPane();
         
        FourPanel = new JPanel();
        FourPanel.setBounds(0, 0, frameWidth, frameHeight);
        FourPanel.setBackground( Color.BLACK );
	FourPanel.setLayout( new BorderLayout() );
        FourPanel.setVisible(true);
        
        GameBG = new MyImageIcon("GameUI/gamemap.png").resize(frameWidth, frameHeight);
        FourDraw = new JLabel();
        FourDraw.setIcon(GameBG);
        FourDraw.setLayout(null);
        
        cleateStroyMode(f,FourDraw,FourPanel,LevelWindow);
        PauseGame(FourDraw,FourPanel);
        //VictoryGame(tempLevel,OneDraw,OnePanel);
        
        FourPanel.add(FourDraw, BorderLayout.CENTER);
        LevelWindow.add(FourPanel);
        LevelWindow.validate();
    }
    
    public void createLevelFIVE(String f){
        //SelectedPanel.setVisible(false);
        LevelPanel.setVisible(false);
        LevelWindow.setVisible(true);
        LevelWindow.repaint();
        LevelWindow.setTitle("LEVEL 5 :");
        
        con = LevelWindow.getContentPane();
        
        FivePanel = new JPanel();
        FivePanel.setBounds(0, 0, frameWidth, frameHeight);
        FivePanel.setBackground( Color.BLACK );
	FivePanel.setLayout( new BorderLayout() );
        FivePanel.setVisible(true);
        
        GameBG = new MyImageIcon("GameUI/gamemap.png").resize(frameWidth, frameHeight);
        FiveDraw = new JLabel();
        FiveDraw.setIcon(GameBG);
        FiveDraw.setLayout(null);
        
        cleateStroyMode(f,FiveDraw,FivePanel,LevelWindow);

        PauseGame(FiveDraw,FivePanel);
        //VictoryGame(tempLevel,OneDraw,OnePanel);
        
        FivePanel.add(FiveDraw, BorderLayout.CENTER);
        LevelWindow.add(FivePanel);
        LevelWindow.validate();
    }
    
    public void createLevelSIX(String f){
        //SelectedPanel.setVisible(false);
        LevelPanel.setVisible(false);
        LevelWindow.setVisible(true);
        LevelWindow.repaint();
        LevelWindow.setTitle("LEVEL 6 :");
        
        con = LevelWindow.getContentPane();
        
        SixPanel = new JPanel();
        SixPanel.setBounds(0, 0, frameWidth, frameHeight);
        SixPanel.setBackground( Color.BLACK );
	SixPanel.setLayout( new BorderLayout() );
        SixPanel.setVisible(true);
        
        GameBG = new MyImageIcon("GameUI/gamemap.png").resize(frameWidth, frameHeight);
        SixDraw = new JLabel();
        SixDraw.setIcon(GameBG);
        SixDraw.setLayout(null);
        
        cleateStroyMode(f,SixDraw,SixPanel,LevelWindow);
        PauseGame(SixDraw,SixPanel);
        //VictoryGame(tempLevel,OneDraw,OnePanel);
        
        SixPanel.add(SixDraw, BorderLayout.CENTER);
        LevelWindow.add(SixPanel);
        LevelWindow.validate();
    }
    
    public MyImageIcon switchCastle(MyImageIcon photo1,MyImageIcon photo2,MyImageIcon photo3,int time){
        MyImageIcon temp = new MyImageIcon("GameUI/MAP.png");
        if(time == 3){
            temp = photo3;
        }else if(time == 2){
            temp = photo2;
        }else if(time == 3){
            temp = photo3;
        }
        return temp;
    }
    
}

class MyPuzzle extends JButton implements MouseListener, MouseMotionListener{
    
    protected MyImageIcon Photo;
    protected int widthButton = 120, heightButton = 120, intersect = 0, Extraintersect=0;
    protected int curX, curY, position;
    private boolean   drag;
    protected JLabel one, two, three, four, five, six, seven, eight, nine;
    private int A;
    
    public MyPuzzle(){ }
    
    public MyPuzzle(String file1,int x, int y, int i){
        
        Photo = new MyImageIcon(file1).resize(widthButton, heightButton);
        curX = x;
        curY = y;
        position = i;
        
        setBounds(curX, curY, widthButton, heightButton);
        //make button off first
        setIcon(Photo);
        //make the button transparent
        setOpaque(false);
        //remove content area
        setContentAreaFilled(false);
        //remove the border
        setBorderPainted(false);
        
        addMouseListener(this);
        addMouseMotionListener(this);
        
        
        
    }
    
    public int getposition(){
        return position;
    }
    
    public int getintersect(){
        return intersect;
    }
    
    public int getExtraintersect(){
        return Extraintersect;
    }
    
    public int checkIntersect(MyPuzzle A){
    
        int checkI=0;
        MyImageIcon check = new MyImageIcon("GameUI/check.png").resize(40,40);
        
        JLabel one = new JLabel();
        one.setBounds(360, 240, 20, 20);
        
        JLabel two = new JLabel();
        two.setBounds(480, 240 ,20, 20);
        
        JLabel three = new JLabel();
        three.setBounds(600, 240, 20, 20);
        
        JLabel four = new JLabel();
        four.setBounds(360, 360, 20, 20);
        
        JLabel five = new JLabel();
        five.setBounds(480, 360, 20, 20);;
        
        JLabel six = new JLabel();
        six.setBounds(600, 360, 20, 20);
        
        JLabel seven = new JLabel();
        seven.setBounds(360, 480, 20, 20);
        
        JLabel eight = new JLabel();
        eight.setBounds(480, 480, 20, 20);
        
        JLabel nine = new JLabel();
        nine.setBounds(600, 480, 20, 20);
        
        ////
        
        JLabel oned = new JLabel();
        oned.setBounds(840, 240, 1, 1);
        
        JLabel twod = new JLabel();
        twod.setBounds(960,240 , 1, 1);
        
        JLabel threed = new JLabel();
        threed.setBounds(1080, 240, 1, 1);
        
        JLabel fourd = new JLabel();
        fourd.setBounds(840, 360, 1, 1);
        
        JLabel fived = new JLabel();
        fived.setBounds(960, 360, 1, 1);;
        
        JLabel sixd = new JLabel();
        sixd.setBounds(1080, 360, 1, 1);
        
        JLabel sevend = new JLabel();
        sevend.setBounds(840, 480, 1, 1);
        
        JLabel eightd = new JLabel();
        eightd.setBounds(960, 480, 1, 1);
        
        JLabel nined = new JLabel();
        nined.setBounds(1080, 480, 1, 1);
        
        if(A.getposition()==1){
            if(A.getBounds().intersects(one.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==2){
            if(A.getBounds().intersects(two.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==3){
            if(A.getBounds().intersects(three.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==4){
            if(A.getBounds().intersects(four.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==5){
            if(A.getBounds().intersects(five.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==6){
            if(A.getBounds().intersects(six.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==7){
            if(A.getBounds().intersects(seven.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==8){
            if(A.getBounds().intersects(eight.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==9){
            if(A.getBounds().intersects(nine.getBounds())){
                checkI++;
            }
        }
        
        if(A.getposition()==11){
            if(A.getBounds().intersects(oned.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==22){
            if(A.getBounds().intersects(twod.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==33){
            if(A.getBounds().intersects(threed.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==44){
            if(A.getBounds().intersects(fourd.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==55){
            if(A.getBounds().intersects(fived.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==66){
            if(A.getBounds().intersects(sixd.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==77){
            if(A.getBounds().intersects(sevend.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==88){
            if(A.getBounds().intersects(eightd.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==99){
            if(A.getBounds().intersects(nined.getBounds())){
                checkI++;
            }
        }
        
        //checkI = A1+A2+A3+A4+A5+A7+A8+A9;
        return checkI;
    }
    
    public int checkIntersectExtra(MyPuzzle A){
    
        int checkI=0;
        MyImageIcon check = new MyImageIcon("GameUI/check.png").resize(40,40);
        
        JLabel one = new JLabel();
        one.setBounds(360, 240, 20, 20);
        
        JLabel two = new JLabel();
        two.setBounds(480, 240 ,20, 20);
        
        JLabel three = new JLabel();
        three.setBounds(600, 240, 20, 20);
        
        JLabel four = new JLabel();
        four.setBounds(720, 240, 20, 20);
        
        JLabel five = new JLabel();
        five.setBounds(840, 240, 20, 20);;
        
        JLabel six = new JLabel();
        six.setBounds(360, 360, 20, 20);
        
        JLabel seven = new JLabel();
        seven.setBounds(480, 360, 20, 20);
        
        JLabel eight = new JLabel();
        eight.setBounds(600, 360, 20, 20);
        
        JLabel nine = new JLabel();
        nine.setBounds(720, 360, 20, 20);
        
        JLabel ten = new JLabel();
        ten.setBounds(840, 360, 1, 1);
        
        JLabel eleven = new JLabel();
        eleven.setBounds(360, 480 , 1, 1);
        
        JLabel twelve = new JLabel();
        twelve.setBounds(480, 480, 1, 1);
        
        JLabel thirteen = new JLabel();
        thirteen.setBounds(600, 480, 1, 1);
        
        JLabel fourteen = new JLabel();
        fourteen.setBounds(720, 480, 1, 1);;
        
        JLabel fifteen = new JLabel();
        fifteen.setBounds(840, 480, 1, 1);
        
 
        
        if(A.getposition()==1){
            if(A.getBounds().intersects(one.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==2){
            if(A.getBounds().intersects(two.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==3){
            if(A.getBounds().intersects(three.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==4){
            if(A.getBounds().intersects(four.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==5){
            if(A.getBounds().intersects(five.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==6){
            if(A.getBounds().intersects(six.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==7){
            if(A.getBounds().intersects(seven.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==8){
            if(A.getBounds().intersects(eight.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==9){
            if(A.getBounds().intersects(nine.getBounds())){
                checkI++;
            }
        }
        
        else if(A.getposition()==10){
            if(A.getBounds().intersects(ten.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==11){
            if(A.getBounds().intersects(eleven.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==12){
            if(A.getBounds().intersects(twelve.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==13){
            if(A.getBounds().intersects(thirteen.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==14){
            if(A.getBounds().intersects(fourteen.getBounds())){
                checkI++;
            }
        }else if(A.getposition()==15){
            if(A.getBounds().intersects(fifteen.getBounds())){
                checkI++;
            }
        }
        return checkI;
}
    
    
    
    public void mousePressed( MouseEvent e )	{ }
    public void mouseReleased( MouseEvent e )	{
        int tempI = checkIntersect(this);
        if(tempI>=1){
            intersect=1;
            System.out.println("intersect >> "+intersect);
            
        
        }
        int tempE = checkIntersectExtra(this);
        if(tempE>=1){
            Extraintersect=1;
            System.out.println("intersect >> "+Extraintersect);
            
        
        }
    }
    public void mouseEntered( MouseEvent e )	{ }	
    public void mouseExited( MouseEvent e )	{ }
    public void mouseMoved( MouseEvent e )	{ }
    public void mouseClicked( MouseEvent e)     { }
    public void mouseDragged( MouseEvent e )	
    { 
	if (!drag){
            curX = curX + e.getX();
            curY = curY + e.getY();
            
            Container p = getParent();
            if (curX < 0)  curX = 0;
            if (curY < 0)  curY = 0;
            if (curX + widthButton  > p.getWidth())   curX = p.getWidth() - widthButton;
            if (curY + (heightButton+90) > p.getHeight())  curY = p.getHeight() - (heightButton+90);             
            setLocation(curX, curY);
        }
    }
    
};

    







    