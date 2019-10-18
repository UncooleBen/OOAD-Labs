package com.OOADLab;

public class GameController {
  private Dealer dealer;
  private Player player;
  private Deck deck;
  GameController()
  {
    dealer=new Dealer();
    player=new Player();
  }

  public void startGame()
  {

  }

  public void displayMenu()
  {
    System.out.println("欢迎进入21点游戏！\n"
        + "1.开始游戏\n"
        + "2.充值\n"
        + "0.退出");
  }
}
