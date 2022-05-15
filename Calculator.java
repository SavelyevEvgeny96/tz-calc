package com.company;

public class Calculator {
    private String result = "";

    public Calculator(DataExpression data){

        int x;

        switch(data.getAction()){

            case "-" :

                this.result = data.getArgumentOne().replace(data.getArgumentTwo(), "");

                break;

            case "+" :

                result = data.getArgumentOne() + data.getArgumentTwo();

                break;

            case "*" :

                x = Integer.parseInt(data.getArgumentTwo());

                for (int i = 0; i < x; i++){

                    result += data.getArgumentOne();

                }

                if(result.length() > 40){

                    result = result.substring(0, 40) + "...";

                }

                break;

            case "/" :

                x = Integer.parseInt(data.getArgumentTwo());

                int stringLength = Math.round(data.getArgumentOne().length() / x);

                result = data.getArgumentOne().substring(0, stringLength);

                break;

        }

    }

    public String getResult() {

        return result;

    }
}
