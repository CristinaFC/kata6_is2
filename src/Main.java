import control.Command;
import control.DownCommand;
import control.LeftCommand;
import control.RightCommand;
import control.UpCommand;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import model.Block;
import view.BlockDisplay;


public class Main extends JFrame{

    private BlockDisplay blockDisplay;
    private Map<String, Command> commands = new HashMap<>();

    public static void main(String []args){
        new Main().execute();
    }
   
    public Main() {
        this.setTitle("Block shifter");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(), BorderLayout.SOUTH);

        Block block = new Block(4,4);
        
        blockDisplay.display(block);
        commands.put("Up", new UpCommand(block));
        commands.put("Down", new DownCommand(block));
        commands.put("Left", new LeftCommand(block));
        commands.put("Right", new RightCommand(block));
    }

    public void execute(){
        this.setVisible(true);
    }
    private JMenuBar toolbar() {
        JMenuBar result = new JMenuBar();
        result.setLayout(new FlowLayout(FlowLayout.CENTER));
        result.add(button("Down"));
        result.add(button("Left"));
        result.add(button("Up"));
        result.add(button("Right"));
        return result;
    }

    private JPanel blockPanel() {
        BlockPanel panel = new BlockPanel();
        this.blockDisplay = panel;
        return panel;
    }

    private JButton button(String command) {
        JButton button = new JButton(command);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(command).execute();
            }
        });
        return button;
    }
   
}
