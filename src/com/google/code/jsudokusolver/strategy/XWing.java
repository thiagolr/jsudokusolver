package com.google.code.jsudokusolver.strategy;

/**
*
* @author David Grant
*/
public class XWing extends AbstractBasicFish {
    public String getName() {
        return "X-Wing";
    }

    @Override
    protected int getFishSize() {
        return 2;
    }
}