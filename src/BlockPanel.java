
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.Block;
import view.BlockDisplay;


public class BlockPanel extends JPanel implements BlockDisplay{

    private static final int SIZE = 100;
    private Block block;
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,700,700);
        g.setColor(Color.BLACK);

        int max = Block.MAX * SIZE;
        for (int i = 0; i < Block.MAX; i++) {
            int d = i * SIZE;
            g.drawLine(d,0,d,max);
            g.drawLine(0,d,max,d);

        }
        if (block == null){
            return;
        }
        g.setColor(Color.RED);
        g.fillRect((block.getX()-1) * SIZE , ((Block.MAX - block.getY())*100),SIZE,SIZE);
    }
    
    public void display(Block block) {
        this.block = block;
        repaint();
    }

    @Override
    public Block block() {
        return block;
    }

    @Override
    public void changed() {
        repaint();
    }
    
}
