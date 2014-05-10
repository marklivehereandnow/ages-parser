/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.util;

/**
 *
 * @author mark
 */
public class CardContentParser {

    public int getTodoCnt() {
        return todoCnt;
    }

    private void setTodoCnt(int todoCnt) {
        this.todoCnt = todoCnt;
    }

    public int getDoneCnt() {
        return doneCnt;
    }

    private void setDoneCnt(int doneCnt) {
        this.doneCnt = doneCnt;
    }

    public boolean isComplete() {
        return isComplete;
    }

    private void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    private int todoCnt = 0;
    private int doneCnt = 0;
    private boolean isComplete = false;

    public void doParse(String content) {

//        String[] strCase = {"case0", "內政點數"};
//        System.out.println(strCase[1]);
        todoCnt = 0;
        doneCnt = 0;
        isComplete = false;
        String cmd = content;
        String[] strTokens = cmd.split(";");// **it's in Chinese, 2 bytes***
//            System.out.println(strTokens);
//        System.out.println("===================================================================");
//        System.out.println("\n" + this.ID + " " + this.卡名 + "=>=>" + this.內容);
        for (String item : strTokens) {
//            System.out.println(item);
            todoCnt++;
//                 System.out.println("--------------------------------------------------------------");

        }
//        System.out.println("----------------------------已解析-----------------------------------");
        for (String item : strTokens) {//按每個句子解析，句子是按分號區隔開來的
            if (item.length() > 0) {
//                    String[] strTokens2 = item.split("[+]");
                String[] strTokens2 = item.split("[:]");//以冒號隔開，左邊的為key，右邊的val

                String key = strTokens2[0];//key是字符串
                String valStr = "";
                int val = -999;//val是整數，使用Integer的解析功能，如果不能解析成整數，系統會報錯
                try {
                    valStr = strTokens2[1];
                    val = Integer.parseInt(strTokens2[1]);//val是整數，使用Integer的解析功能，如果不能解析成整數，系統會報錯
                } catch (Exception ex) {

                }

                String[] strCase = {"case0",
                    "內政點數",
                    "軍事點數",
                    "建築上限",
                    "食物需求",
                    "擴充人口",
                    "殖民點數",
                    "內政手牌上限",
                    "軍事手牌上限",
                    "軍力",
                    "資源",
                    "每個玩家免費擴充人口",
                    "食物",
                    "科技",
                    "文化",
                    "科技生產",
                    "文化生產",
                    "食物生產",
                    "笑臉",
                    "每個玩家科技",
                    "每個玩家食物",
                    "黃點",
                    "藍點",
                    "每個玩家資源",
                    "資源生產",
                        "步",
                        "馬",
                        "炮",
                        "飛機",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                };

                boolean 不知道 = true;
                for (int k = 1; k < strCase.length; k++) {
                    if (key.equals(strCase[k])) {
//                        System.out.println("..." + strCase[k]);
                        doneCnt++;
                        不知道 = false;
                    }
                }

                if (不知道) {
                    System.out.println("   不知道, [key]=" + key + " [val]=" + valStr);
                }
                /*

                 case "每個玩家科技":
                 doneCnt++;
                 break;
                 case "每個玩家食物":
                 doneCnt++;
                 break;
                 //                        case "每個玩家科技":
                 //                        doneCnt++;
                 //                        break;
                 //                        case "每個玩家科技":
                 //                        doneCnt++;
                 //                        break;
                 //                        case "每個玩家科技":
                 //                        doneCnt++;
                 //                        break;
                 //                        case "每個玩家科技":
                 //                        doneCnt++;
                 //                        break;
                 //                        case "每個玩家科技":
                 //                        doneCnt++;
                 //                        break;
                 //                        case "每個玩家科技":
                 //                        doneCnt++;
                 //                        break;

                 default:
                 System.out.println("   不知道, [key]=" + key + " [val]=" + valStr);
               
                 }
                 */

                /*
                 if (key.equals("黃點")) {
                 System.out.println("黃點:" + val);
                 doneCnt++;
                 }
                 if (key.equals("藍點")) {
                 System.out.println("藍點:" + val);
                 doneCnt++;
                 }
                 */
            }
        }
//        System.out.println("");
//        System.out.println("----------------------------解析結果-----------------------------------");
        if (doneCnt == todoCnt) {
//                isDone = true;
//            this.是否完全解析完畢 = true;
            setIsComplete(true);
//            System.out.println("是否全部解析完畢? YES!");
        } else {
//            System.out.println("是否全部解析完畢? NO!");
            setIsComplete(false);
        }

//        System.out.println("  應該解析個數:" + todoCnt);
//        System.out.println("  已解析個數" + doneCnt);
    }

}
