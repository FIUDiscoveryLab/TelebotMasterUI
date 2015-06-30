/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telebot.righthandfingers;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeCellEditor;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//telebot.righthandfingers//RightHandFingers//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "RightHandFingersTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "output", openAtStartup = false)
@ActionID(category = "Window", id = "telebot.righthandfingers.RightHandFingersTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_RightHandFingersAction",
        preferredID = "RightHandFingersTopComponent"
)
@Messages({
    "CTL_RightHandFingersAction=RightHandFingers",
    "CTL_RightHandFingersTopComponent=RightHandFingers Window",
    "HINT_RightHandFingersTopComponent=This is a RightHandFingers window"
})
public final class RightHandFingersTopComponent extends TopComponent {

    private final JScrollBar THUMB_FINGER = new JScrollBar(JScrollBar.VERTICAL,0,0,0,100);
    private final JScrollBar GROOMING_FINGER = new JScrollBar(JScrollBar.VERTICAL,0,0,0,100);
    private JScrollBar MIDDLE_FINGER = new JScrollBar(JScrollBar.VERTICAL,0,0,0,100);
    private final JScrollBar RING_FINGER = new JScrollBar(JScrollBar.VERTICAL,0,0,0,100);
    private final JScrollBar LITTLE_FINGER = new JScrollBar(JScrollBar.VERTICAL,0,0,0,100);
    
    private final JTextArea THUMB_TEXTAREA = new JTextArea("Thumb value: ");
    private final JTextArea GROOMING_TEXTAREA = new JTextArea("Grooming value: ");
    private final JTextArea MIDDLE_TEXTAREA = new JTextArea("Middle value: ");
    private final JTextArea RING_TEXTAREA = new JTextArea("Ring value: ");
    private final JTextArea LITTLE_TEXTAREA =  new JTextArea("Little value: ");
    
    private final JTextField THUMB_TEXTFIELD = new JTextField("0");
    private final JTextField GROOMING_TEXTFIELD = new JTextField("0");
    private final JTextField MIDDLE_TEXTFIELD = new JTextField("0");
    private final JTextField RING_TEXTFIELD = new JTextField("0");
    private final JTextField LITTLE_TEXTFIELD = new JTextField("0");
    
    private final JButton BTN_HOLD = new JButton("Hold");
    
    private boolean wholeHand;
    
    public RightHandFingersTopComponent() {
        initComponents();
        setName(Bundle.CTL_RightHandFingersTopComponent());
        setToolTipText(Bundle.HINT_RightHandFingersTopComponent());
        
        wholeHand = false;
        
        GridBagConstraints gridBagConstrains = new GridBagConstraints();
        
        setLayout(new GridBagLayout());
        
        
        gridBagConstrains.gridheight = 6;
        
        THUMB_FINGER.setPreferredSize(new Dimension(30,200));      
        gridBagConstrains.gridx = 0;
        gridBagConstrains.gridy = 0;        
        add(THUMB_FINGER,gridBagConstrains);        
        
        GROOMING_FINGER.setPreferredSize(new Dimension(30,200));       
        gridBagConstrains.gridx = 1;
        gridBagConstrains.gridy = 0;        
        add(GROOMING_FINGER,gridBagConstrains);
        
        MIDDLE_FINGER.setPreferredSize(new Dimension(30,200));
        MIDDLE_FINGER.setMaximum(100);
        MIDDLE_FINGER.setBlockIncrement(1);
        gridBagConstrains.gridx = 2;
        gridBagConstrains.gridy = 0;        
        add(MIDDLE_FINGER,gridBagConstrains);
        
        RING_FINGER.setPreferredSize(new Dimension(30, 200));        
        gridBagConstrains.gridx = 3;
        gridBagConstrains.gridy = 0;     
        add(RING_FINGER,gridBagConstrains);
        
        LITTLE_FINGER.setPreferredSize(new Dimension(30,200));        
        gridBagConstrains.gridx = 4;
        gridBagConstrains.gridy = 0;       
        add(LITTLE_FINGER, gridBagConstrains);
        
        gridBagConstrains.gridheight = 1;
        
        //Setting the JTextArea controls 
        
        gridBagConstrains.gridx = 5;
        gridBagConstrains.gridy = 1;
        add(THUMB_TEXTAREA, gridBagConstrains);
        
        gridBagConstrains.gridx = 5;
        gridBagConstrains.gridy = 2;
        add(GROOMING_TEXTAREA,gridBagConstrains);
        
        gridBagConstrains.gridx = 5;
        gridBagConstrains.gridy = 3;
        add(MIDDLE_TEXTAREA,gridBagConstrains);
        
        gridBagConstrains.gridx = 5;
        gridBagConstrains.gridy = 4;
        add(RING_TEXTAREA, gridBagConstrains);
        
        gridBagConstrains.gridx = 5;
        gridBagConstrains.gridy =5;
        add(LITTLE_TEXTAREA,gridBagConstrains);
        
        //setting the Button 
        gridBagConstrains.gridx = 5;
        gridBagConstrains.gridy = 0;
        add(BTN_HOLD,gridBagConstrains);
        
        THUMB_TEXTFIELD.setPreferredSize(new Dimension(30, 20));
        gridBagConstrains.gridx = 6;
        gridBagConstrains.gridy = 1;
        add(THUMB_TEXTFIELD,gridBagConstrains);
        
        GROOMING_TEXTFIELD.setPreferredSize(new Dimension(30, 20));
        gridBagConstrains.gridx = 6;
        gridBagConstrains.gridy = 2;
        add(GROOMING_TEXTFIELD, gridBagConstrains);
        
        MIDDLE_TEXTFIELD.setPreferredSize(new Dimension(30, 20));
        gridBagConstrains.gridx = 6;
        gridBagConstrains.gridy = 3;
        add(MIDDLE_TEXTFIELD,gridBagConstrains);
        
        RING_TEXTFIELD.setPreferredSize(new Dimension(30, 20));
        gridBagConstrains.gridx = 6;
        gridBagConstrains.gridy = 4;
        add(RING_TEXTFIELD, gridBagConstrains);
        
        LITTLE_TEXTFIELD.setPreferredSize(new Dimension(30, 20));
        gridBagConstrains.gridx = 6;
        gridBagConstrains.gridy = 5;
        add(LITTLE_TEXTFIELD, gridBagConstrains);
        
        BTN_HOLD.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                wholeHand = !wholeHand;

                        if (wholeHand) {

                            enableWholeHand(wholeHand);

                            setMidPoint();
                            BTN_HOLD.setText("Release");
                        } else {

                            enableWholeHand(wholeHand);
                            setMidPoint();

                            BTN_HOLD.setText("Hold");

                        }
            }
        }); 
        
        MIDDLE_FINGER.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (wholeHand) {
                    THUMB_FINGER.setValue(MIDDLE_FINGER.getValue());
                    GROOMING_FINGER.setValue(MIDDLE_FINGER.getValue());
                    RING_FINGER.setValue(MIDDLE_FINGER.getValue());
                    LITTLE_FINGER.setValue(MIDDLE_FINGER.getValue());
                }
                
                MIDDLE_TEXTFIELD.setText(String.valueOf( MIDDLE_FINGER.getValue()));
            }
        });
        
        THUMB_FINGER.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                THUMB_TEXTFIELD.setText(String.valueOf(THUMB_FINGER.getValue()));
            }
        });
        
        GROOMING_FINGER.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                GROOMING_TEXTFIELD.setText(String.valueOf(GROOMING_FINGER.getValue()));
            }
        });
        
        RING_FINGER.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                RING_TEXTFIELD.setText(String.valueOf(RING_FINGER.getValue()));
            }
        });
        
        LITTLE_FINGER.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                LITTLE_TEXTFIELD.setText(String.valueOf(LITTLE_FINGER.getValue()));
            }
        });
        
        
    }
    private void setMidPoint(){
        THUMB_FINGER.setValue(50);
        GROOMING_FINGER.setValue(50);
        MIDDLE_FINGER.setValue(50);
        RING_FINGER.setValue(50);
        LITTLE_FINGER.setValue(50);  
    }
    private void enableWholeHand(Boolean value){
        THUMB_FINGER.setEnabled(!value);
        GROOMING_FINGER.setEnabled(!value);
        RING_FINGER.setEnabled(!value);
        LITTLE_FINGER.setEnabled(!value);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
