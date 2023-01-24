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

import mainpackage.Game;
import mainpackage.CallGame;
import mainpackage.MainApplication.MenuHandler;

public class window{
    
    private JFrame      ScreenWindow, CreditWindow, SquareWindow, VolumeWindow, LoadWindow;
    protected JPanel    MenuPanel, StoryPanel, SpeedPanel, CreditPanel, CreatePanel, TextPanel, ListPanel, AvatarPanel;
    protected JPanel    AvatarNamePanel, VolumePanel, TempPanel;
    private JTextField  NameText;
    private JList       AvatarList;
    private JSlider     VolumeSlider;
    private JLabel      MenuDraw, StoryDraw, UnlimDraw, CreditDraw, CreateDraw, TextDraw, AvatarDraw, NameAvatarDraw;
    private JLabel      VolumeDraw, ReadDraw;
    private MyImageIcon MenuBG, StoryBG, UnlimBG, CreditBG, NewgameBG;
    private MyImageIcon AvatarPic1, AvatarPic2, AvatarPic3, AvatarPic4, AvatarPic5;
    protected MyButton    storyButton, unlimitButton, creditButton, quitButton, sfxButton, musicButton;
    protected MyButton    newButton, loadButton, backButton, resetButton, confirmButton, yesButton;
    protected MyButton    startUButton, rankButton;
    protected MySound     MainThemeSong;
    
    private String      messageFromText;
    private Container   con;
    
    private String [] avatar = {"Thara","Aqua","Wind","Fairy","Darkness"};
    //MenuHandler mHandler = new MenuHandler();
    
    //private Object [] messageFromList;
    PlayerSaved player = new PlayerSaved();
    //Game g = new Game();
    
    private int frameWidth = 1280, frameHeight = 720;  
    
    private int popupCurX = 600, popupCurY = 200;  
    private int popupWidth = 960, popupHeight = 540;  
    private int squareWidth = 500, squareHeight = 540; 
    
    public void createFrame(MenuHandler mHandler){
        
        ScreenWindow = new JFrame();
        ScreenWindow.setTitle("PUZZLE PHOTO");
        ScreenWindow.setSize(frameWidth,frameHeight);
        ScreenWindow.setLocationRelativeTo(null);
        ScreenWindow.getContentPane().setBackground(Color.black);
        ScreenWindow.setResizable(false);
        ScreenWindow.setLayout(null);
        ScreenWindow.setVisible(true);
        ScreenWindow.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        
        MainThemeSong = new MySound("musics_sfx/mainthemesong.wav"); MainThemeSong.playLoop();
        // MAIN MENU SCREEN //
        MenuPanel = new JPanel();
        //MenuPanel = (JPanel)getContentPane();
        
        ///*checkXY
        MenuPanel.addMouseListener(new MouseAdapter() {
        @Override 
        public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + "," + e.getY());
        }
        });
        //*/
        MenuPanel.setBounds(0, 0, frameWidth, frameHeight);
        MenuPanel.setBackground( Color.BLACK );
	MenuPanel.setLayout( new BorderLayout() );
        
        //Addcomponent to menupane
        MenuBG = new MyImageIcon("menuUI/puzzle.png").resize(frameWidth, frameHeight);
        
        //Add Background
        MenuDraw = new JLabel();
        MenuDraw.setIcon(MenuBG);
        MenuDraw.setLayout(null);
        
        storyButton = new MyButton("menuUI/1STORY_OFF.png","menuUI/1STORY_ON.png",807,283, "long");
        MenuDraw.add(storyButton);
        storyButton.addActionListener(mHandler);
        storyButton.setActionCommand("story");
        
        unlimitButton = new MyButton("menuUI/SPEED_OFF.png","menuUI/SPEED_ON.png",807,358, "long");
        MenuDraw.add(unlimitButton);
        unlimitButton.addActionListener(mHandler);
        unlimitButton.setActionCommand("speed");
        
        creditButton = new MyButton("menuUI/3CREDITS_OFF.png","menuUI/3CREDITS_ON.png",807,433, "long");
        MenuDraw.add(creditButton);
        
        creditButton.addActionListener(mHandler);
        creditButton.setActionCommand("credits");
        
        quitButton = new MyButton("menuUI/4QUITS_OFF.png","menuUI/4QUITS_ON.png",807,508, "long");
        MenuDraw.add(quitButton);
        quitButton.addActionListener(mHandler);
        quitButton.setActionCommand("exit");
        
        
        //volumeSlider = new MySlider();
        musicButton = new MyButton("menuUI/MUSICS_OFF.png","menuUI/MUSICS_ON.png",955,583, "circle");//
        MenuDraw.add(musicButton);
        musicButton.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) { 
                if(e.getButton() == MouseEvent.BUTTON1) {//LEFT CLICK
                  if(MainThemeSong.soundopen()){
                      MainThemeSong.stop();
                  }else{
                      MainThemeSong.playLoop();
                  }
                }
                if(e.getButton() == MouseEvent.BUTTON3) {//RIGHT CLECK
                    createSliderframe();
                }
            }
        });
        musicButton.addActionListener(mHandler);
        musicButton.setActionCommand("music");
        
        // STORY MODE SCREEN //
        StoryPanel = new JPanel();
        StoryPanel.setBounds(0, 0, frameWidth, frameHeight);
        StoryPanel.setBackground( Color.BLACK );
	StoryPanel.setLayout( new BorderLayout() );
        
        StoryBG = new MyImageIcon("menuUI/StorymodeBG.png").resize(frameWidth, frameHeight);
        StoryDraw = new JLabel();
        StoryDraw.setIcon(StoryBG);
        StoryDraw.setLayout(null);
        
        newButton = new MyButton("menuUI/NEW_OFF.png","menuUI/NEW_ON.png",465,260, "long");//
        StoryDraw.add(newButton);
        newButton.addActionListener(mHandler);
        newButton.setActionCommand("newgame");
        
        loadButton = new MyButton("menuUI/LOAD_OFF.png","menuUI/LOAD_ON.png",465,345, "long");//
        StoryDraw.add(loadButton);
        loadButton.addActionListener(mHandler);
        loadButton.setActionCommand("loadgame");
        loadButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) 
            {
                player.readFile();
                String name = player.GetName();
                String avatar = player.GetAvatar();
                int level = player.GetLevel();
                String readprint = "Name : " + name + " | Avatar : " + avatar + " | Level : " + level;
		int input = JOptionPane.showConfirmDialog(null,readprint, "Do you want to continue playing this saved?",JOptionPane.YES_NO_OPTION);
                if(input == 0){//yes
                    CallGame c = new CallGame();
                    //ScreenWindow.dispose();
                    c.callGame(player);
                }else if(input == 1){//no
                    
                }
            }
	});
        
        backButton = new MyButton("menuUI/BACK_OFF.png","menuUI/BACK_ON.png",1060,600, "half");//
        StoryDraw.add(backButton);
        backButton.addActionListener(mHandler);
        backButton.setActionCommand("back");
        
        
        // UNLIMITED MODE SCREEN //
        SpeedPanel = new JPanel();
        SpeedPanel.setBounds(0, 0, frameWidth, frameHeight);
        SpeedPanel.setBackground( Color.BLACK );
	SpeedPanel.setLayout( new BorderLayout() );
        
        UnlimBG = new MyImageIcon("menuUI/UnlimitmodeBG.png").resize(frameWidth, frameHeight);
        UnlimDraw = new JLabel();
        UnlimDraw.setIcon(UnlimBG);
        UnlimDraw.setLayout(null);
        
        startUButton = new MyButton("menuUI/ONE_OFF.png","menuUI/ONE_ON.png",465,260, "long");//
        UnlimDraw.add(startUButton);
        startUButton.addActionListener(mHandler);
        startUButton.setActionCommand("start");
        startUButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
             
            }
            
        });
        
        rankButton = new MyButton("menuUI/TWO_OFF.png","menuUI/TWO_ON.png",465,345, "long");//
        UnlimDraw.add(rankButton);
        rankButton.addActionListener(mHandler);
        rankButton.setActionCommand("rank");
        
        backButton = new MyButton("menuUI/BACK_OFF.png","menuUI/BACK_ON.png",1060,600, "half");//
        UnlimDraw.add(backButton);
        backButton.addActionListener(mHandler);
        backButton.setActionCommand("back");
        

        MenuPanel.add(MenuDraw, BorderLayout.CENTER);
        ScreenWindow.add(MenuPanel);
        StoryPanel.add(StoryDraw, BorderLayout.CENTER);
        ScreenWindow.add(StoryPanel);
        SpeedPanel.add(UnlimDraw, BorderLayout.CENTER);
        ScreenWindow.add(SpeedPanel);
        
        ScreenWindow.validate();
    }
    
    public void createSliderframe(){
        
        VolumeWindow = new JFrame();
        VolumeWindow.setTitle("Adjust Volume of Music");
        VolumeWindow.setResizable(false);
        VolumeWindow.setSize(320, 120);
        VolumeWindow.setLocationRelativeTo(null);
        VolumeWindow.setLayout(new FlowLayout(FlowLayout.CENTER));
        VolumeWindow.setVisible(true);
        VolumeWindow.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        VolumeWindow.setAlwaysOnTop(true);

        VolumeDraw = new JLabel("Select volume of Music",JLabel.CENTER);
        VolumeDraw.setLayout(null);
        
        VolumeSlider = new JSlider(-40,6);
        VolumeSlider.setMajorTickSpacing(10);
        VolumeSlider.setPaintTicks(true);
        //VolumeSlider.setPaintLabels(true);
        VolumeSlider.addChangeListener(new ChangeListener (){
            public void stateChanged(ChangeEvent e){
                if(MainThemeSong.currentVolume == -40){
                    MainThemeSong.currentVolume = -80;
                }
                System.out.println("volume: "+MainThemeSong.currentVolume);
                MainThemeSong.currentVolume = VolumeSlider.getValue();
                MainThemeSong.fc.setValue(MainThemeSong.currentVolume);
            }
        
        });
        VolumeWindow.add(VolumeDraw);
        VolumeWindow.add(VolumeSlider);
        
        VolumeWindow.validate();
    }
    
    public void createCreditFrame(){
        
        CreditWindow = new JFrame();
        CreditWindow.setTitle("Credits");
        CreditWindow.setSize(popupWidth, popupHeight);
        //CreditWindow.setBounds(popupCurX, popupCurY, popupWidth, popupHeight);
        CreditWindow.setLocationRelativeTo(null);
        CreditWindow.getContentPane().setBackground(Color.black);
        CreditWindow.setResizable(false);
        CreditWindow.setLayout(null);
        CreditWindow.setVisible(true);
        CreditWindow.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        
//        CreditWindow.toFront();
//        CreditWindow.requestFocus();
        
        // CREDIT MODE SCREEN //
        CreditPanel = new JPanel();
        CreditPanel.setBounds(0, 0, popupWidth, popupHeight);
        CreditPanel.setBackground( Color.BLACK );
	CreditPanel.setLayout( new BorderLayout() );
        
        CreditBG = new MyImageIcon("menuUI/CREDITyeye.png").resize(popupWidth, popupHeight);
        CreditDraw = new JLabel();
        CreditDraw.setIcon(CreditBG);
        CreditDraw.setLayout(null);
        
        CreditWindow.addWindowListener(new WindowAdapter() {
         public void windowOpened(WindowEvent e) {
                creditButton.setEnabled(false);
         }
         public void windowClosed(WindowEvent e) {
                creditButton.setEnabled(true);
         }
        });

        CreditWindow.setAlwaysOnTop(true);
        CreditPanel.add(CreditDraw, BorderLayout.CENTER);
        CreditWindow.add(CreditPanel);
        CreditWindow.validate();
        
    }

    public void createNewGameFrame(){
        
        SquareWindow = new JFrame();
        SquareWindow.setTitle("Create new save");
        SquareWindow.setSize(515, 578);
        SquareWindow.setLocationRelativeTo(null);
        SquareWindow.getContentPane().setBackground(Color.black);
        SquareWindow.setResizable(false);
        SquareWindow.setLayout(null);
        SquareWindow.setVisible(true);
        SquareWindow.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        con = SquareWindow.getContentPane();
        
        TextPanel = new JPanel();
        TextPanel.setBounds(130,75,340,30);
        TextPanel.setBackground(Color.black);
        TextPanel.setLayout(new GridLayout());
        
        NameText = new JTextField();
        TextPanel.add(NameText);
        con.add(TextPanel);
        //String s = NameText.getText();
        NameText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                String s = NameText.getText();
                System.out.println(s);
                player.SetTempName(s);
            }
        });
        
        
        AvatarNamePanel = new JPanel();
        AvatarNamePanel.setBounds(200,120,270,30);
        AvatarNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        NameAvatarDraw = new JLabel();
        NameAvatarDraw.setBounds(200,120,270,30);
        
        AvatarPic1 = new MyImageIcon("avatar/A_001.png").resize(215,330);
        AvatarPic2 = new MyImageIcon("avatar/A_002.png").resize(215,330);
        AvatarPic3 = new MyImageIcon("avatar/A_003.png").resize(215,330);
        AvatarPic4 = new MyImageIcon("avatar/A_004.png").resize(215,330);
        AvatarPic5 = new MyImageIcon("avatar/A_005.png").resize(215,330);
        
        ListPanel = new JPanel();
        ListPanel.setBounds(290,200,170,100);
        ListPanel.setBackground(Color.black);
        ListPanel.setLayout(new GridLayout());
        
        AvatarPanel = new JPanel();
        AvatarPanel.setBounds(35,180,215,330);
        AvatarPanel.setOpaque(false);
        //AvatarPanel.setBackground(Color.black);
        AvatarPanel.setLayout(new GridLayout());
        AvatarDraw = new JLabel();
        
        AvatarList = new JList( avatar );
	AvatarList.setVisibleRowCount(5);
	AvatarList.addListSelectionListener( new ListSelectionListener() {
            public void valueChanged( ListSelectionEvent e ){
		if( !e.getValueIsAdjusting() )
		{
                    String SelectedAvatar = (String) AvatarList.getSelectedValue();
                    System.out.println(SelectedAvatar);
                    
                    if(SelectedAvatar!=null){
                    if(SelectedAvatar.equalsIgnoreCase("Thara")){
                        System.out.println(SelectedAvatar);
                        AvatarDraw.setIcon(AvatarPic1);
                    }else if(SelectedAvatar.equalsIgnoreCase("Aqua")){
                        System.out.println(SelectedAvatar);
                        AvatarDraw.setIcon(AvatarPic2);
                    }else if(SelectedAvatar.equalsIgnoreCase("Wind")){
                        System.out.println(SelectedAvatar);
                        AvatarDraw.setIcon(AvatarPic3);
                    }else if(SelectedAvatar.equalsIgnoreCase("Fairy")){
                        System.out.println(SelectedAvatar);
                        AvatarDraw.setIcon(AvatarPic4);
                    }else if(SelectedAvatar.equalsIgnoreCase("Darkness")){
                        System.out.println(SelectedAvatar);
                        AvatarDraw.setIcon(AvatarPic5);
                    }else if(SelectedAvatar==null){
                        //System.out.println(SelectedAvatar);
                        AvatarDraw.setIcon(AvatarPic1);
                    }
                    }if(SelectedAvatar==null){
                        //System.out.println(SelectedAvatar);
                        AvatarDraw.setIcon(AvatarPic1);
                    }
                    player.SetTempAvatar(SelectedAvatar);
                    String s = NameText.getText();
                    player.SetTempName(s);
                    System.out.printf("name: %s ,avatar: %s \n",player.GetName(),player.GetAvatar());
                    System.out.printf("name: %s ,avatar: %s \n",s,player.GetTempAvatar());
                    NameAvatarDraw.setText(SelectedAvatar);
                    AvatarPanel.repaint();
                    SquareWindow.repaint();
		}
            }
	});
        
        ListPanel.add(AvatarList);
        con.add(ListPanel);
        
        //Default
        if(player.GetAvatar().equalsIgnoreCase("Thara")){
            AvatarDraw.setIcon(AvatarPic1);
            NameAvatarDraw.setText(player.GetAvatar());
        }
        
        AvatarNamePanel.add(NameAvatarDraw);
        AvatarPanel.add(AvatarDraw);
        AvatarPanel.repaint();
        con.add(AvatarPanel);
        con.add(AvatarNamePanel);
        
        CreatePanel = new JPanel();
        
        //NewgamePanel.setSize(squareWidth, squareHeight);
        CreatePanel.setBounds(0, 0, squareWidth, squareHeight);
        CreatePanel.setBackground( Color.BLACK );
	CreatePanel.setLayout( new BorderLayout());
        
        NewgameBG = new MyImageIcon("menuUI/CreateBG.png").resize(squareWidth, squareHeight);
        CreateDraw = new JLabel();
        CreateDraw.setIcon(NewgameBG);
        CreateDraw.setLayout(null);
        
        
        resetButton = new MyButton("menuUI/Reset_OFF.png","menuUI/Reset_ON.png",260,480, "vsmall");//
        CreateDraw.add(resetButton);
        resetButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) 
            {
                NameText.setText("");
		NameAvatarDraw.setText(" ");
		AvatarList.clearSelection();
            }
	});
        resetButton.setActionCommand("reset");
        
        confirmButton = new MyButton("menuUI/Confirm_OFF.png","menuUI/Confirm_ON.png",380,480, "vsmall");//
        CreateDraw.add(confirmButton);
        confirmButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) 
            {
		int input = JOptionPane.showConfirmDialog(null,"Do you want to play as this save", "Confirm to play",JOptionPane.YES_NO_CANCEL_OPTION);
                if(input == 0){
                    
                    player.SetName(player.GetTempName());
                    player.SetAvatar(player.GetTempAvatar());                 
                    player.printFile();
                    player.SetLevel(1);
                    SquareWindow.dispose();
                    CallGame c = new CallGame();
                    //ScreenWindow.dispose();
                    c.callGame(player);
                }else if(input == 1){
                    player.PlayerDefault();
                    SquareWindow.dispose();
                }else if(input == 2){
                    
                }
                System.out.printf("name: %s ,avatar: %s \n",player.GetName(),player.GetAvatar());
            }
	});
        confirmButton.setActionCommand("reset");
        
        SquareWindow.addWindowListener(new WindowAdapter() {
         public void windowOpened(WindowEvent e) {
                newButton.setEnabled(false);
         }
         public void windowClosed(WindowEvent e) {
                newButton.setEnabled(true);
                //System.out.printf("name: %s ,avatar: %s \n",player.GetName(),player.GetAvatar());
         }
        });
        
        CreatePanel.add(CreateDraw, BorderLayout.CENTER);
        
        SquareWindow.add(CreatePanel);
        //SquareWindow.setVisible(true);
        
        SquareWindow.validate();
        SquareWindow.repaint();
    }
 
///////////////  
}

//My image use to adjust image
class MyImageIcon extends ImageIcon{
    
    public MyImageIcon(String fname)  { super(fname); }
    public MyImageIcon(Image image)   { super(image); }

    public MyImageIcon resize(int width, int height)
    {
	Image oldimg = this.getImage();
	Image newimg = oldimg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new MyImageIcon(newimg);
    }
};

//My button
class MyButton extends JButton implements MouseListener{
    
    protected MyImageIcon   buttonOFF, buttonON;
    protected int widthButton = 20, heightButton = 20;
    protected int curX, curY;
    
    public MyButton(){ }
    
    public MyButton(String file1, String file2,int x, int y, String type){
        
        String T = type;
        if(T.equalsIgnoreCase("long")){
            widthButton = 346; heightButton = 56;
        }else if(T.equalsIgnoreCase("circle")){
            widthButton = 62; heightButton = 62;
        }else if(T.equalsIgnoreCase("half")){
            widthButton = 170; heightButton = 55;
        }else if(T.equalsIgnoreCase("vsmall")){
            widthButton = 95; heightButton = 32;
        }else if(T.equalsIgnoreCase("slevel")){
            widthButton = 122; heightButton = 122;
        }else if(T.equalsIgnoreCase("blevel")){
            widthButton = 184; heightButton = 184;
        }else if(T.equalsIgnoreCase("pause")){
            widthButton = 40; heightButton = 40;
        }else if(T.equalsIgnoreCase("endgame")){
            widthButton = 160; heightButton = 75;
        }else if(T.equalsIgnoreCase("game")){
            widthButton = 140; heightButton = 70;
        }
        
        buttonOFF = new MyImageIcon(file1).resize(widthButton, heightButton);
        buttonON = new MyImageIcon(file2).resize(widthButton, heightButton);
        curX = x;
        curY = y;
        
        setBounds(curX, curY, widthButton, heightButton);
        //make button off first
        setIcon(buttonOFF);
        //make the button transparent
        setOpaque(false);
        //remove content area
        setContentAreaFilled(false);
        //remove the border
        setBorderPainted(false);
        
        addMouseListener(this);
    }
    
    public void mousePressed( MouseEvent e )	{ }
    public void mouseReleased( MouseEvent e )	{ }
    public void mouseEntered( MouseEvent e )	{
        setIcon(buttonON);
    }	
    public void mouseExited( MouseEvent e )	{
        setIcon(buttonOFF);
    }
    public void mouseMoved( MouseEvent e )	{ }
    public void mouseClicked( MouseEvent e)     { }

};

class MySound{
    private Clip clip;
    float previousVolume = 0;
    float currentVolume = -1;
    public boolean open = false;
    FloatControl fc;
    
    public MySound(String filename)
    {
	try
	{
            java.io.File file = new java.io.File(filename);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
	}
	catch (Exception e) { e.printStackTrace(); }
    }
    public void playOnce()   { clip.setMicrosecondPosition(0); clip.start(); }
    public void playLoop()   { 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
        open = true;
    }
    public boolean soundopen(){
        return open;
    }
    public void stop(){ 
        clip.stop(); 
        open = false;
    }
    public void volumeDown(){
        currentVolume += 1.0f;
        if(currentVolume > 0.6f){
            currentVolume = 0.6f;
        }
        fc.setValue(currentVolume);
    }
    public void volumeUp(){
        currentVolume -= 1.0f;
        if(currentVolume > -80.0f){
            currentVolume = 80.0f;
        }
        fc.setValue(currentVolume);
    }
    
};


