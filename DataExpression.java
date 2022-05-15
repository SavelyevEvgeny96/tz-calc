package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataExpression {

    private final String REGEX = "\".{0,10}\"\\s?[+*/-]\\s?((\".{0,10}\")|(\\d[0]?))";

    private final String REGEX_FOR_ACTION = "[+*/-]";

    private final String REGEX_FOR_STRING = "\".+?\"";

    private final String argumentOne;

    private final String argumentTwo;

    private final String action;

    public DataExpression(String stringRequest) throws Exception {

        isValid(stringRequest);

        String[] strings = getData(stringRequest);

        this.argumentOne = strings[0];

        this.argumentTwo = strings[1];

        this.action = strings[2];

    }

    private void isValid(String stringRequest) throws Exception {

        Pattern pattern = Pattern.compile(REGEX);

        Matcher matcher = pattern.matcher(stringRequest);

        if(!matcher.matches()){

            throw new Exception("Некорретно введены данные!");

        }

    }

    private String[] getData(String stringRequest) throws Exception {

        int i = 0;

        String[] strings = new String[3];

        Pattern pattern = Pattern.compile(REGEX_FOR_STRING);

        Matcher matcher = pattern.matcher(stringRequest);

        while (matcher.find()){

            strings[i] = stringRequest.substring(matcher.start(), matcher.end()).replaceAll("\"", "");

            i++;

        }

        String stringOne = strings[0];

        pattern = Pattern.compile(REGEX_FOR_ACTION);

        String searchAction = stringRequest.substring(stringOne.length() + 2, stringRequest.length());

        String action = "";

        int indexAction = 0;

        matcher = pattern.matcher(searchAction);

        while (matcher.find()){

            indexAction = matcher.start();

            action = searchAction.substring(indexAction, matcher.end());

            break;

        }

        if (i == 2 && (action.equals("+") || action.equals("-"))){

            strings[2] = action;

            return strings;

        } else if (i == 1 && (action.equals("*") || action.equals("/"))) {

            strings[1] = searchAction.substring(indexAction + 1, searchAction.length()).trim();

            strings[2] = action;

            return strings;

        } else {

            throw new Exception("Некорретно введены данные!");

        }

    }

    public String getArgumentOne() {

        return argumentOne;

    }

    public String getArgumentTwo() {

        return argumentTwo;

    }

    public String getAction() {

        return action;

    }
}
