/*No-Name
6313139 Ruttiyaporn Kongtrakul 
6313141 Vatcharapong Laklaem
6313174 Natthabodi Bochol
6213202 Nitipoom Soomsakit*/
package mainpackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;

public class MainApplication {

    MenuHandler mHandler = new MenuHandler();
    window window = new window();
    ScreenChange screen = new ScreenChange(window);
    GameFrame GF = new GameFrame();
    
    public static void main(String[] args) {
        
        new MainApplication();
        
    }
    
    public MainApplication(){
        window.createFrame(mHandler);
        screen.showMainMenu();
    }
    
    public class MenuHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            String menuChoose = event.getActionCommand();
            
            switch(menuChoose){
                case "story" : screen.showStoryMenu();break;
                case "speed" : GF.createSelected(); break;
                case "credits" : window.createCreditFrame(); break;
                case "exit" : screen.exitGame(); break;
                case "back" : screen.showMainMenu();break;
                case "newgame" : window.createNewGameFrame(); break;
                case "loadgame" :  break;
                case "start" : break;
                case "ranking" : break;
                case "music" : break;
                case "sfx" : break;
            }
        }

    }
    
}
