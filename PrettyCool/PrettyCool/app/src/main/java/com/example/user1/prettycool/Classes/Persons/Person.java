package com.example.user1.prettycool.Classes.Persons;


import com.example.user1.prettycool.Classes.Objects;

/**
 * Created by user1 on 24.02.2016.
 */
public class Person extends Objects {
     int HP = 100;
     int LVL = 0;
     int EXP = 2500;
     int ATTACK = 1;
     int SHIELD = 0;
     int SPEED;
     String NAME = "Barry";
     int SPRITE;
     boolean isAlive = true;
     int MOVEPOINTS;
     int[] COORD = {15,15};
     int ATTACKDISTANCE;

     public int getATTACKDISTANCE() {
          return ATTACKDISTANCE;
     }

     public void setATTACKDISTANCE(int ATTACKDISTANCE) {
          this.ATTACKDISTANCE = ATTACKDISTANCE;
     }



     public int getHP() {
          return HP;
     }

     public void setHP(int HP) {
          this.HP = HP;
     }

     public int getLVL() {
          return LVL;
     }

     public void setLVL(int LVL) {
          this.LVL = LVL;
     }

     public int getEXP() {
          return EXP;
     }

     public void setEXP(int EXP) {
          this.EXP = EXP;
     }

     public int getATTACK() {
          return ATTACK;
     }

     public void setATTACK(int ATTACK) {
          this.ATTACK = ATTACK;
     }

     public int getSHIELD() {
          return SHIELD;
     }

     public void setSHIELD(int SHIELD) {
          this.SHIELD = SHIELD;
     }

     public int getSPEED() {
          return SPEED;
     }

     public void setSPEED(int SPEED) {
          this.SPEED = SPEED;
     }

     public String getNAME() {
          return NAME;
     }

     public void setNAME(String NAME) {
          this.NAME = NAME;
     }

     public int getSPRITE() {
          return SPRITE;
     }

     public void setSPRITE(int SPRITE) {
          this.SPRITE = SPRITE;
     }

     public boolean isAlive() {
          return isAlive;
     }

     public void setIsAlive(boolean isAlive) {
          this.isAlive = isAlive;
     }

     public int getMOVEPOINTS() {
          return MOVEPOINTS;
     }

     public void setMOVEPOINTS(int MOVEPOINTS) {
          this.MOVEPOINTS = MOVEPOINTS;
     }

     public int[] getCOORD() {
          return COORD;
     }

     public void setCOORD(int[] COORD) {
          this.COORD = COORD;
     }






}
