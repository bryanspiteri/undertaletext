package github.hyblocker.undertaletext.other;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;

public class Window extends JFrame implements KeyListener, ActionListener
{
	
	//
	//      WINDOW
	//
	public JTextPane displayArea;
    static final String newline = System.getProperty("line.separator");
    
	public static boolean ready=false;
    
    public Window(String name) {
    	super(name);
    }
    
    public static void MakeWindow(Game caller) {
    	try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //Schedule a job for event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(caller);
            }
        });
    }
    
    private static void createAndShowGUI(Game caller) {
        //Create and set up the window.
        Window frame = new Window("UNDERTALE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Load the icon to memory
        ImageIcon icon = new ImageIcon(UndertaleBoot.class.getResource("/icon.png"));
        
        //Change the icon to the UNDERTALE icon
        frame.setIconImage(icon.getImage());
        
        //Set up the content pane.
        frame.addComponentsToPane();
        
        //Set frame size
        Dimension d = new Dimension(697,418); //624*471 (x-16,y-9)
        frame.setSize(d);
        frame.setMaximumSize(new Dimension(698,419));
        frame.setMinimumSize(d);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.displayArea.requestFocusInWindow();
        caller._windinst = frame;
        ready=true;
    }
    
    private void addComponentsToPane() {
        
        displayArea = new JTextPane();
        displayArea.setEditable(false);
        
        /*Uncomment this if you wish to turn off focus
          traversal.  The focus subsystem consumes
          focus traversal keys, such as Tab and Shift Tab.
          If you uncomment the following line of code, this
          disables focus traversal and the Tab events will
          become available to the key event listener.*/
        
        //typingArea.setFocusTraversalKeysEnabled(false);
        
        displayArea = new JTextPane() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D graphics2d = (Graphics2D) g;
                graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_OFF);
                graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                        RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
                super.paintComponent(g);
            }
        };
        displayArea.setEditable(false);
        displayArea.addKeyListener(this);
        
        //Line Spacing
        float lineSpacing = -0.3f;
        StyledDocument doc = displayArea.getStyledDocument();
        Element e = doc.getParagraphElement(0);
        MutableAttributeSet mas = new SimpleAttributeSet(); 
        StyleConstants.setLineSpacing(mas, lineSpacing);
        StyleConstants.setSpaceAbove(mas, lineSpacing);
        StyleConstants.setSpaceBelow(mas, lineSpacing);
        //displayArea.putClientProperty(com.sun.java.swing.SwingUtilities2.AA_TEXT_PROPERTY_KEY, null);
        
        //Load Font
        InputStream fontStream = UndertaleBoot.class.getResourceAsStream("/fonts/gameFont.ttf");
    	try {
			Font gameFont = Font.createFont(Font.TRUETYPE_FONT,fontStream);
			gameFont=gameFont.deriveFont(Font.PLAIN, 32);
			//GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(gameFont);
			displayArea.setFont(gameFont);
			
			//Add Font to the StyleConstants
	        StyleConstants.setFontFamily(mas, gameFont.getFamily());
	        StyleConstants.setFontSize(mas, gameFont.getSize());
		} catch (FontFormatException | IOException ex) {
			ex.printStackTrace();
		}
    	
    	//Apply Font
        doc.setCharacterAttributes(0, doc.getLength() + 1, mas, false);
        //Apply Line Spacing
        doc.setParagraphAttributes(0, 1000, mas, true);
        
        getContentPane().add(displayArea, BorderLayout.CENTER);
    }
    
    public Font getFont(String fontPath) throws Exception {
        java.net.URL url = UndertaleBoot.class.getResource(fontPath);
        return Font.createFont(Font.TRUETYPE_FONT, new File(url.toURI()));
    }
    
    //
    //       INPUT HANDLER (TO GET INPUT)
    //
    
    @Override
	public void actionPerformed(ActionEvent key) {
		Game._windinst.displayArea.requestFocusInWindow();
		//Game._windinst.typingArea.setText("");
		//Game._windinst.typingArea.requestFocusInWindow();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		Game._windinst.displayArea.requestFocusInWindow();
		//Game._windinst.typingArea.setText("");
		//Game._windinst.typingArea.requestFocusInWindow();
        String keyString;
        int keyCode;
        keyCode = key.getKeyCode();
        keyString =KeyEvent.getKeyText(keyCode);
        keyString = keyString+"";
        
        KeyCode keye = ConvertStringToKey(key);
        if(!Input.currKeys.contains(keye)) {
        Input.currKeys.add(keye);
        }
	}

	@Override
	public void keyReleased(KeyEvent key) {
		Game._windinst.displayArea.requestFocusInWindow();
		//Game._windinst.typingArea.setText("");
		//Game._windinst.typingArea.requestFocusInWindow();
        String keyString;
        int keyCode;
        keyCode = key.getKeyCode();
        keyString =KeyEvent.getKeyText(keyCode);
        keyString = keyString+"";
        
        KeyCode keye = ConvertStringToKey(key);

        if(Input.currKeys.contains(keye)) {
        Input.currKeys.remove(keye);
    	}
	}

	@Override
	public void keyTyped(KeyEvent key) {
		Game._windinst.displayArea.requestFocusInWindow();
		
	}

	public KeyCode ConvertStringToKey(KeyEvent keyevent) {
		
		//Get the keycode
		int keyCode = keyevent.getKeyCode();
		//get the location (LeftShift,RightShift, etc.)
		int location = keyevent.getKeyLocation();
		
		if(keyCode==65) {
			return KeyCode.A;
		} else if(keyCode==66) {
			return KeyCode.B;
		} else if(keyCode==67) {
			return KeyCode.C;
		} else if(keyCode==68) {
			return KeyCode.D;
		} else if(keyCode==69) {
			return KeyCode.E;
		} else if(keyCode==70) {
			return KeyCode.F;
		} else if(keyCode==71) {
			return KeyCode.G;
		} else if(keyCode==72) {
			return KeyCode.H;
		} else if(keyCode==73) {
			return KeyCode.I;
		} else if(keyCode==74) {
			return KeyCode.J;
		} else if(keyCode==75) {
			return KeyCode.K;
		} else if(keyCode==76) {
			return KeyCode.L;
		} else if(keyCode==77) {
			return KeyCode.M;
		} else if(keyCode==78) {
			return KeyCode.N;
		} else if(keyCode==79) {
			return KeyCode.O;
		} else if(keyCode==80) {
			return KeyCode.P;
		} else if(keyCode==81) {
			return KeyCode.Q;
		} else if(keyCode==82) {
			return KeyCode.R;
		} else if(keyCode==83) {
			return KeyCode.S;
		} else if(keyCode==84) {
			return KeyCode.T;
		} else if(keyCode==85) {
			return KeyCode.U;
		} else if(keyCode==86) {
			return KeyCode.V;
		} else if(keyCode==87) {
			return KeyCode.W;
		} else if(keyCode==88) {
			return KeyCode.X;
		} else if(keyCode==89) {
			return KeyCode.Y;
		} else if(keyCode==90) {
			return KeyCode.Z;
		} else if(keyCode==48) {
			return KeyCode.Zero;
		} else if(keyCode==49) {
			return KeyCode.One;
		} else if(keyCode==50) {
			return KeyCode.Two;
		} else if(keyCode==51) {
			return KeyCode.Three;
		} else if(keyCode==52) {
			return KeyCode.Four;
		} else if(keyCode==53) {
			return KeyCode.Five;
		} else if(keyCode==54) {
			return KeyCode.Six;
		} else if(keyCode==55) {
			return KeyCode.Seven;
		} else if(keyCode==56) {
			return KeyCode.Eight;
		} else if(keyCode==57) {
			return KeyCode.Nine;
		} else if(keyCode==96) {
			return KeyCode.Numpad0;
		} else if(keyCode==97) {
			return KeyCode.Numpad1;
		} else if(keyCode==98) {
			return KeyCode.Numpad2;
		} else if(keyCode==99) {
			return KeyCode.Numpad3;
		} else if(keyCode==100) {
			return KeyCode.Numpad4;
		} else if(keyCode==101) {
			return KeyCode.Numpad5;
		} else if(keyCode==102) {
			return KeyCode.Numpad6;
		} else if(keyCode==103) {
			return KeyCode.Numpad7;
		} else if(keyCode==104) {
			return KeyCode.Numpad8;
		} else if(keyCode==105) {
			return KeyCode.Numpad9;
		} else if(keyCode==16 && location == KeyEvent.KEY_LOCATION_LEFT) {
			return KeyCode.LeftShift;
		} else if(keyCode==16 && location == KeyEvent.KEY_LOCATION_RIGHT) {
			return KeyCode.RightShift;
		} else if(keyCode==17 && location == KeyEvent.KEY_LOCATION_LEFT) {
			return KeyCode.LeftControl;
		} else if(keyCode==17 && location == KeyEvent.KEY_LOCATION_RIGHT) {
			return KeyCode.RightControl;
		} else if(keyCode==32) {
			return KeyCode.Space;
		} else if(keyCode==10  && location == KeyEvent.KEY_LOCATION_STANDARD) {
			return KeyCode.Enter;
		} else if(keyCode==8) {
			return KeyCode.Backspace;
		} else if(keyCode==27) {
			return KeyCode.Escape;
		} else if(keyCode==44) {
			return KeyCode.Comma;
		} else if(keyCode==47) {
			return KeyCode.ForwardSlash;
		} else if(keyCode==92) {
			return KeyCode.BackSlash;
		} else if(keyCode==59) {
			return KeyCode.SemiColon;
		} else if(keyCode==222) {
			return KeyCode.Apostrophy;
		} else if(keyCode==91) {
			return KeyCode.LeftBracket;
		} else if(keyCode==93) {
			return KeyCode.RightBracket;
		} else if(keyCode==61) {
			return KeyCode.Plus;
		} else if(keyCode==45) {
			return KeyCode.Minus;
		} else if(keyCode==112) {
			return KeyCode.F1;
		} else if(keyCode==113) {
			return KeyCode.F2;
		} else if(keyCode==114) {
			return KeyCode.F3;
		} else if(keyCode==115) {
			return KeyCode.F4;
		} else if(keyCode==116) {
			return KeyCode.F5;
		} else if(keyCode==117) {
			return KeyCode.F6;
		} else if(keyCode==118) {
			return KeyCode.F7;
		} else if(keyCode==119) {
			return KeyCode.F8;
		} else if(keyCode==120) {
			return KeyCode.F9;
		} else if(keyCode==121) {
			return KeyCode.F10;
		} else if(keyCode==122) {
			return KeyCode.F11;
		} else if(keyCode==123) {
			return KeyCode.F12;
		} else if(keyCode==38) {
			return KeyCode.Up;
		} else if(keyCode==40) {
			return KeyCode.Down;
		} else if(keyCode==37) {
			return KeyCode.Left;
		} else if(keyCode==39) {
			return KeyCode.Right;
		} else if(keyCode==18) {
			return KeyCode.Alt;
		/*} else if(keyCode==123) {
			return KeyCode.Tab;*/
		} else if(keyCode==110) {
			return KeyCode.NumPeroid;
		} else if(keyCode==107) {
			return KeyCode.NumPlus;
		} else if(keyCode==109) {
			return KeyCode.NumMinus;
		} else if(keyCode==111) {
			return KeyCode.NumSlash;
		} else if(keyCode==106) {
			return KeyCode.NumAsterisk;
		} else if(keyCode==10 && location == KeyEvent.KEY_LOCATION_NUMPAD) {
			return KeyCode.NumEnter;
		}
		
		
		return KeyCode.Backspace;
	}
	
	//
	//      METHODS (CLEAR, PRINT, PRINTLN, ETC.)
	//
	
	public void clear() {
		Game._windinst.displayArea.setText("");
		Game._windinst.displayArea.requestFocusInWindow();
	}
	
	public void print(String text) {
		Game._windinst.displayArea.setText(Game._windinst.displayArea.getText()+text);
	}
	
	public void println(String text) {
		Game._windinst.displayArea.setText(Game._windinst.displayArea.getText()+text+newline);
	}

}
