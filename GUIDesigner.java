import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class GUIDesigner extends Frame {

   public static Frame fr;
   public static FileOutputStream fos;
   public static PrintWriter pw;
   public static GUIDesigner gd;
   public static Button create, save, show,b;
   public static TextField title, width, height, file,c;
   public static TextArea code,d;
   public static Checkbox frame, button, label, textField, textArea;
   public static CheckboxGroup grp;
   public static Label tLabel,wLabel,hLabel, fLabel, info, coord;
   public static String s1,s2,s3,s4,s5,s6,s7,s8,s9,s,fileName;
   public int selection, cWidth, cHeight, fWidth, fHeight, mX, mY, nfWidth, nfHeight;
   public static int count, preSelect, check;
   public static Label a;

   public static void main (String [] args) {
      gd = new GUIDesigner () ;
      gd.show();

   }

   public GUIDesigner () {
      fWidth = 800;
      fHeight = 570;
      nfWidth = 0;
      nfHeight = 0;
      cWidth = 0;
      cHeight = 0;
      mX = 0;
      mY = 0;
      count = 0;
      preSelect = -5;
      check = 0;
      s1 = "/******************************************\n* Code Generated through GUI Builder\n* Desgined by Sai Compusys ***/\n\n";
      s2 = "";
      s3 = "";
      s4 = "";
      s5 = "";
      s6 = "";
      s7 = "";
      s8 = "";
      s9 = "";
      s = "";
      fileName = "";
      setTitle("GUI Designer Tool ");
      setSize(fWidth,fHeight);
      setLayout(null);
      setCursor(Cursor.CROSSHAIR_CURSOR);
      addWindowListener(new winLis());
      mLis ml = new mLis();
      addMouseListener(ml);
      addMouseMotionListener(ml);
      create = new Button ("create");
      save = new Button ("save");
      show = new Button ("code");
      title = new TextField();
      width = new TextField();
      height = new TextField();
      file = new TextField();
      code = new TextArea();
      tLabel = new Label ("Title:");
      wLabel = new Label ("Width:");
      hLabel = new Label ("Height:");
      fLabel = new Label ("File Name:");
      info = new Label("Ready...");
      coord = new Label ("(0,0)");
      create.addActionListener(new buttonListener () );
      save.addActionListener(new buttonListener () );
      show.addActionListener(new buttonListener () );
      grp = new CheckboxGroup();
      frame = new Checkbox ("Frame",grp,false);
      button = new Checkbox ("Button",grp,false);
      label = new Checkbox ("Label",grp,false);
      textArea = new Checkbox ("TextArea",grp,false);
      textField = new Checkbox ("TextField",grp,false);
      selection = -5;
      radLis rl = new radLis();
      frame.addItemListener(rl);
      button.addItemListener (rl);
      label.addItemListener (rl);
      textField.addItemListener (rl);
      textArea.addItemListener (rl);
      add(tLabel);
      add(wLabel);
      add(hLabel);
      add(frame);
      add(button);
      add(label);
      add(textField);
      add(textArea);
      add(create);
      add(title);
      add(width);
      add(height);
      add(file);
      add(fLabel);
      add(save);
      add(info);
      add(coord);
      add(show);
      frame.setBounds(10,30,80,20);
      label.setBounds(10,50,80,20);
      button.setBounds(10,70,80,20);
      textField.setBounds(10,90,80,20);
      textArea.setBounds(10,110,80,20);
      tLabel.setBounds(10,150,80,20);
      title.setBounds(10,170,80,20);
      wLabel.setBounds(10,200,80,20);
      width.setBounds(10,220,80,20);
      hLabel.setBounds(10,250,80,20);
      height.setBounds(10,270,80,20);
      create.setBounds(10,290,50,20);
      fLabel.setBounds(10,320,80,20);
      file.setBounds(10,340,80,20);
      save.setBounds(10,360,50,20);
      coord.setBounds(10,390,80,20);
      info.setBounds(10,410,80,20);
      show.setBounds(10,440,50,20);
   }
   public void paint (Graphics g) {
      g.setColor(Color.red);
      g.fillRect(0,0,100,fHeight);
      if (selection != -5) {
         g.setColor(Color.black);
         g.drawRect(115,30,nfWidth,nfHeight);
      }
   }
   private class buttonListener implements ActionListener {
      public void actionPerformed (ActionEvent e) {
         if (e.getSource() == create) {
            fileName = file.getText();
            cWidth = Integer.parseInt(width.getText());
            cHeight = Integer.parseInt(height.getText());
            selection = preSelect;
            if (selection == 0) {
               nfWidth = cWidth;
               nfHeight = cHeight;
               s2 = "import java.awt.*;\nimport java.awt.event.*;\npublic class "+fileName+" extends Frame {\n";
               s3 += "   public static "+fileName+" instance;\n";
               s4 = "   public static void main (String [] args) {\n      instance = new "+fileName+"();\n      instance.show();\n   }\n";
               s5 = "   public "+fileName+" () {\n      setTitle(\""+title.getText()+"\");\n      setSize("+nfWidth+" , "+nfHeight+");\n      setLayout(null);\n      addWindowListener(new WindowAdapter () { public void windowClosing (WindowEvent e) { System.exit(0); } } );\n";
               s7 = "   }\n   private class buttonListener implements ActionListener {\n      public void actionPerformed (ActionEvent e) {\n";
               s9 = "      }\n   }\n}";
               fWidth = nfWidth + 130;
               fHeight = nfHeight + 45;
               gd.setSize(fWidth,fHeight);
               repaint();
            }
            if (selection == 1) {
               a = new Label (title.getText());
               gd.add(a);
            }
            if (selection == 2) {
               b = new Button (title.getText());
               gd.add(b);
            }
            if (selection == 3) {
               c = new TextField ();
               gd.add(c);
            }
            if (selection == 4) {
               d = new TextArea ();
               gd.add(d);
            }
         }
         if (e.getSource() == save) {
            try {
               String str = fileName+".java";
               fos = new FileOutputStream (str);
               pw = new PrintWriter(fos);
               s = s1+s2+s3+s4+s5+s6+s7+s8+s9;
               pw.println(s);
               pw.close();
               info.setText("File Created!");
            } catch (Exception exc) {}
         }
         if (e.getSource() == show) {
            if (check == 0) {
               fr = new Frame("Code Generator");
               fr.setSize(350,450);
               fr.setLayout(new BorderLayout());
               fr.setLocation(450,0);
               fr.add(code);
               code.setText(s1+s2+s3+s4+s5+s6+s7+s8+s9);
               fr.show();
               check = 1;
               show.setLabel("Hide");
            } else {
               fr.dispose();
               check = 0;
               show.setLabel("Code");
            }
         }
      }
   }
   private class mLis extends MouseAdapter implements MouseMotionListener  {
      public void mousePressed (MouseEvent e) {
      }
      public void mouseDragged (MouseEvent e) {
      }
      public void mouseMoved (MouseEvent e) {
         if (( ( (selection!=0)&&(selection!=-5) )&&(selection != -10) )&&((e.getX()>=115&&e.getX()<=(fWidth-15))&&(e.getY()>=30&&e.getY()<=(fHeight-15)))){
            mX = e.getX()+5;
            mY = e.getY()+5;
            coord.setText("("+(mX-115)+","+(mY-30)+")");
            if (selection == 1) {
               a.setBounds(mX,mY,cWidth,cHeight);
            }
            if (selection == 2) {
               b.setBounds(mX,mY,cWidth,cHeight);
            }
            if (selection == 3) {
               c.setBounds(mX,mY,cWidth,cHeight);
            }
            if (selection == 4) {
               d.setBounds(mX,mY,cWidth,cHeight);
            }
         }
      }
      public void mouseClicked (MouseEvent e) {
         if (( ( (selection!=0)&&(selection!=-5) )&&(selection != -10) )&&((e.getX()>=115&&e.getX()<=(fWidth-15))&&(e.getY()>=30&&e.getY()<=(fHeight-15)))){
            if (selection == 1) {
               String l = JOptionPane.showInputDialog("Enter the name of the label (Cancel for default):");
               if (l == null) {
                  l = "a"+count;
               }
               a.setBounds(e.getX()+5,e.getY()+5,cWidth,cHeight);
               s3 += "   public static Label "+l+";\n";
               s6 += "      "+l+" = new Label(\""+title.getText()+"\");\n      add("+l+");\n"+"      "+l+".setBounds("+(e.getX()-115)+","+(e.getY()-30)+","+cWidth+","+cHeight+");\n";
               preSelect = selection;
               selection = -10;
            }
            if (selection == 2) {
               String l = JOptionPane.showInputDialog("Enter the name of the button (Cancel for default):");
               if (l == null) {
                  l = "a"+count;
               }
               b.setBounds(e.getX()+5,e.getY()+5,cWidth,cHeight);
               s3 += "   public static Button "+l+";\n";
               s6 += "      "+l+" = new Button(\""+title.getText()+"\");\n      "+l+".addActionListener(new buttonListener());\n      add("+l+");\n      "+l+".setBounds("+(e.getX()-115)+","+(e.getY()-30)+","+cWidth+","+cHeight+");\n";
               s8 += "         if (e.getSource() == "+l+") {\n         }\n";
               preSelect = selection;
               selection = -10;
            }
            if (selection == 3) {
               String l = JOptionPane.showInputDialog("Enter the name of the TextField (Cancel for default):");
               if (l == null) {
                  l = "a"+count;
               }
               c.setBounds(e.getX()+5,e.getY()+5,cWidth,cHeight);
               s3 += "   public static TextField "+l+";\n";
               s6 += "      "+l+" = new TextField(\""+title.getText()+"\");\n      add("+l+");\n"+"      "+l+".setBounds("+(e.getX()-115)+","+(e.getY()-30)+","+cWidth+","+cHeight+");\n";
               preSelect = selection;
               selection = -10;
            }
            if (selection == 4) {
               String l = JOptionPane.showInputDialog("Enter the name of the TextArea (Cancel for default):");
               if (l == null) {
                  l = "a"+count;
               }
               d.setBounds(e.getX()+5,e.getY()+5,cWidth,cHeight);
               s3 += "   public static TextArea "+l+";\n";
               s6 += "      "+l+" = new TextArea(\""+title.getText()+"\");\n      add("+l+");\n"+"      "+l+".setBounds("+(e.getX()-115)+","+(e.getY()-30)+","+cWidth+","+cHeight+");\n";
               preSelect = selection;
               selection = -10;
            }
            count++;
         }
      }
      public void mouseReleased (MouseEvent e) {
      }
   }
   private class winLis extends WindowAdapter {
      public void windowClosing (WindowEvent e) {
         System.exit(0);
      }
   }
   private class radLis implements ItemListener {
      public void itemStateChanged (ItemEvent e) {
         title.setText("");
         width.setText("");
         height.setText("");
         if (e.getSource() == frame) {
            preSelect = selection = 0;
         }
         if (e.getSource() == label) {
            preSelect = selection = 1;
         }
         if (e.getSource() == button) {
            preSelect = selection = 2;
         }
         if (e.getSource() == textField) {
            preSelect = selection = 3;
         }
         if (e.getSource() == textArea) {
            preSelect = selection = 4;
         }
      }
   }
}
