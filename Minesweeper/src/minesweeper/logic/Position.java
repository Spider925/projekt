/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.logic;

/**
 *
 * @author sanapci
 */
class Position{
    int x,y; Position(int x,int y){
        this.x = x;
        this.y = y;
    } 
    
    public boolean compareTo(Position o){ return (o.x == x && o.y == y);}
}