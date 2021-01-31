package view;

import model.Block;

public interface BlockDisplay extends Block.Observer{
    Block block();
    void display(Block block);
    
}
