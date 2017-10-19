

package guiapp1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Michael
 */
public class GuiApp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new GuiApp1();
    }
    
    public GuiApp1()
        {
            //creat a new JFrame object from the JFrame constructor
            JFrame guiFrame = new JFrame();
            //to make sure the window closing closes the app
            guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //to give the title bar something to say
            guiFrame.setTitle("Example GUI");
            //to set the size of the window
            guiFrame.setSize(300, 250);
            //to set the window to the center of the screen, instead of the
            //top left
            guiFrame.setLocationRelativeTo(null);
            
            //to make it easier to populate example entries later...
            String[] fruitOptions =
            {
                "Apple", "Apricot", "Banana", "Cherry", "Date", "Kiwi", "Orange"
                ,"Pear", "Strawberry"
            };
            
            String[] vegOptions = 
            {
                "Asparagus", "Beans", "Broccoli", "Cabbage", "Carrot", "Celery",
                "Cucumber", "Leek", "Mushroom", "Pepper", "Radish", "Shallot", 
                "Spinach", "Swede", "Turnip"
            };
            
            //sets the variable type to final so that we can use it in an 
            //inner class
            final JPanel comboPanel = new JPanel();
            //the JLabel is setting the "graphical properties" of the label
            JLabel comboLbl = new JLabel("Fruits:");
            //the combobox is populating with fruitOptions from above
            JComboBox fruits = new JComboBox(fruitOptions);
            
            //a JPanel uses the FlowLayout as its default layout manager
            //I assume this is akin to a flow layout in html/css
            //therefore we add the JLabel first so that it will show up first
            comboPanel.add(comboLbl);
            comboPanel.add(fruits);
            
            final JPanel listPanel = new JPanel();
            //because our layout will have a button controlling visibility
            //we need one of our panels to be invisible to start
            listPanel.setVisible(false);
            JLabel listLbl = new JLabel("Vegetables:");
            JList vegs = new JList(vegOptions);
            //the horizontal wrap makes the list items display in two columns
            //and is called a "newspaper style"
            vegs.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            
            listPanel.add(listLbl);
            listPanel.add(vegs);
            
            JButton vegFruitButton = new JButton("Fruit or Veg");
            vegFruitButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    //when the fruit of veg button is pressed the setVisible
                    //value of each of the panels is switched from true 
                    //to value or vice versa
                    listPanel.setVisible(!listPanel.isVisible());
                    comboPanel.setVisible(!comboPanel.isVisible());
                }
            });
            
            guiFrame.add(comboPanel, BorderLayout.NORTH);
            guiFrame.add(listPanel, BorderLayout.CENTER);
            guiFrame.add(vegFruitButton, BorderLayout.SOUTH);
            
            guiFrame.setVisible(true);
           
        }
    
}
