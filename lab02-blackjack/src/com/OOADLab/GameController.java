package com.OOADLab;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

/**
 * This class is used in lab02-blackjack as a part of OOAD-Labs.
 *
 * <p>This class controls the whole game process, including I/O and error check.
 *
 * @author Shangzhen Li
 */
public class GameController {
  private Dealer dealer;
  private Player player;
  private Deck deck;
  private Scanner in = new Scanner(System.in);
  private PrintStream out = System.out;

  GameController() {
    dealer = new Dealer();
    player = new Player();
  }

  /** The init() method is used as the main menu. Loop infinitely until user quits the program. */
  public void init() {
    int op;
    while (true) {
      displayMenu();
      op = in.nextInt();
      switch (op) {
        case 1: // User chooses to start game
          player.resetHand();
          dealer.resetHand();
          int chipBalance = player.getChipBalance();
          if (chipBalance < 10) // Check remaining chip
          {
            out.printf("余额不足，最小为10，当前余额%d，请前往充值界面充值", chipBalance);
            break;
          }
          out.print("设置使用牌组数（最少1副，最多6副）："); // Set number of suits
          int numOfSuit = in.nextInt();
          if (numOfSuit >= 1 && numOfSuit <= 6) {
            deck = new Deck(numOfSuit);
            out.print("初始化完成，请下注，当前拥有" + chipBalance + "个筹码\n" + "输入赌注（最小10）：");
            int bet = in.nextInt();
            if (bet < 10 || bet > chipBalance) // Check input bet
            {
              out.println("筹码输入错误，返回主界面");
              break;
            }
            player.payBet(bet);
            startGame();
          } else {
            out.println("输入错误，返回主界面");
          }
          break;
        case 2: // User chooses to buy chip
          out.print("输入要买的筹码数：");
          int chip = in.nextInt();
          if (chip < 0) {
            out.println("输入不可为负，返回主界面");
            break;
          }
          player.addChipBalance(chip);
          out.println("购买成功，返回主界面");
          break;
        case 0: // User chooses to quit game
          return;
      }
    }
  }

  /**
   * Every time startGame() is called, a new round of game begins with the current attributes set by
   * init().
   */
  private void startGame() {
    int bet = player.getCurrentBet();
    for (int i = 0; i < 2; i++) // Deal the first two cards to player
    {
      dealer.dealPlayer(player, deck);
    }
    for (int i = 0; i < 2; i++) // Deal the first two cards to dealer
    {
      dealer.dealDealer(deck);
    }
    int playerValue = player.getHandValue(0);
    int dealerValue = dealer.getHandValue(0);
    if (dealerValue == 21 && playerValue != 21) { // Someone gets 21 points with the first 2 cards
      displayBothHands();
      playerLose(bet);
      return;
    }
    if (dealerValue != 21 && playerValue == 21) {
      displayBothHands();
      playerWin(bet);
      return;
    }
    if (dealerValue == 21 && playerValue == 21) {
      displayBothHands();
      draw(bet);
      return;
    }
    boolean moreCard;
    List<Card> cards;
    do { // Provide information and ask whether player wants more card
      moreCard = false;
      cards = dealer.getHand(0).getCards();
      out.print("庄家手牌：暗牌1张");
      for (int i = 1; i < cards.size(); i++) {
        out.printf(" [%s]", cards.get(i).toString());
      }
      out.print("\n玩家手牌：");
      cards = player.getHand(0).getCards();
      for (Card c : cards) {
        out.printf("[%s] ", c.toString());
      }
      out.println();
      playerValue = player.getHandValue(0);
      String option;
      if (playerValue <= 21) {
        out.print("是否继续要牌？(y/n)");
        option = in.next();
        if (option.equalsIgnoreCase("y")) {
          moreCard = true;
          dealer.dealPlayer(player, deck);
        }
      } else {
        out.println("玩家手牌点数超过21\n");
      }
    } while (moreCard);
    while (dealer.getHandValue(0) <= 16) { // Deal cards to dealer
      dealer.dealDealer(deck);
    }
    displayBothHands();
    playerValue = player.getHandValue(0);
    dealerValue = dealer.getHandValue(0);
    out.printf("庄家点数：%d\n", dealerValue);
    out.printf("玩家点数：%d\n", playerValue);
    if (playerValue > 21) { // Judge game result
      playerLose(bet);
    } else {
      if (dealerValue > 21) {
        playerWin(bet);
      } else {
        if (dealerValue > playerValue) {
          playerLose(bet);
        } else if (dealerValue == playerValue) {
          draw(bet);
        } else {
          playerWin(bet);
        }
      }
    }
  }

  /**
   * Called when player wins.
   *
   * @param bet
   */
  private void playerWin(int bet) {
    out.print("你赢了\n");
    out.printf("结算前筹码：%d\n", player.getChipBalance());
    out.printf("本局赌注：%d\n", bet);
    bet *= 1.5;
    player.applyReward(bet);
    out.printf("结算后筹码：%d\n", player.getChipBalance());
  }

  /**
   * Called when player loses.
   *
   * @param bet
   */
  private void playerLose(int bet) {
    out.print("你输了\n");
    out.printf("结算前筹码：%d\n", player.getChipBalance());
    out.printf("本局赌注：%d\n", bet);
    bet *= -1.5;
    player.applyReward(bet);
    out.printf("结算后筹码：%d\n", player.getChipBalance());
  }

  /**
   * Called when the game draws.
   *
   * @param bet
   */
  private void draw(int bet) {
    out.print("平局\n赌注返还\n");
    out.printf("结算前筹码：%d\n", player.getChipBalance());
    out.printf("本局赌注：%d\n", bet);
    player.applyReward(bet);
    out.printf("结算后筹码：%d\n", player.getChipBalance());
  }

  private void displayMenu() {
    System.out.print("欢迎进入21点游戏！\n" + "1.开始游戏\n" + "2.充值\n" + "0.退出\n" + "请选择：");
  }

  private void displayBothHands() {
    List<Card> cards = dealer.getHand(0).getCards();
    out.print("庄家手牌：");
    for (Card c : cards) {
      out.printf("[%s] ", c.toString());
    }
    out.print("\n玩家手牌：");
    cards = player.getHand(0).getCards();
    for (Card c : cards) {
      out.printf("[%s] ", c.toString());
    }
    out.println();
  }
}
