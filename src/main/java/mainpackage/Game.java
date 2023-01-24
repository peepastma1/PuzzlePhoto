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
import mainpackage.window;

public class Game{
    
    LevelHandler lHandler = new LevelHandler();
    PlayerSaved         player = new PlayerSaved();
    private JFrame      LevelWindow;
    GameFrame GF = new GameFrame();
    int tLevel = GF.gettemplevelplayer();
    
    public Game(){}
    
    public void setplayer(PlayerSaved p){
        player = p;
    }
    
    public void StartGame(){
        //System.out.println("asdsadsadas");
        GF.setGameplayer(player);
        GF.createLevelFrame(lHandler);
    }
    
    public class LevelHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            String levelChoose = event.getActionCommand();
            
            switch(levelChoose){
//                case "story" : screen.showStoryMenu();break;
//                case "unlimit" : screen.showUnlimMenu();break;
//                case "credits" : window.createCreditFrame(); break;
//                case "exit" : screen.exitGame(); break;
//                case "back" : screen.showMainMenu();break;
//                case "newgame" : window.createNewGameFrame(); break;
                case "Level_ONE" :      
                                        GF.settemplevelplayer(1); 
                                        GF.goToLevel(GF.gettemplevelplayer());
                                        break;
                case "Level_TWO" :      
                                        GF.settemplevelplayer(2);
                                        GF.goToLevel(GF.gettemplevelplayer());
                                        break;
                case "Level_THREE" :    
                                        GF.settemplevelplayer(3); 
                                        GF.goToLevel(GF.gettemplevelplayer());
                                        break;
                case "Level_FOUR" :     
                                        GF.settemplevelplayer(4); 
                                        GF.goToLevel(GF.gettemplevelplayer());
                                        break;
                case "Level_FIVE" :     
                                        GF.settemplevelplayer(5);
                                        GF.goToLevel(GF.gettemplevelplayer());
                                        break;
                case "Level_SIX" :      
                                        GF.settemplevelplayer(6); 
                                        GF.goToLevel(GF.gettemplevelplayer());
                                        break;
                //case "back" : break;
            }
        }

    }
    
}
