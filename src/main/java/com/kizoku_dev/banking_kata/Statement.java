package com.kizoku_dev.banking_kata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Account.
 */
public class Statement {

    private static final String HEADERS = "Date\t\tAmount\t\tBalance";
    private final List<StatementRecord> statementRecords;

    public Statement() {
        this.statementRecords = new ArrayList<>();
    }

    public double addRecord(double value, double currentBalance) {
        double newBalance = currentBalance + value;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.statementRecords.add(new StatementRecord(value, dateFormat.format(new Date()), newBalance));
        return newBalance;
    }

    public String printStatement() {
        StringBuilder statement = new StringBuilder(HEADERS);
        for (StatementRecord statementRecord : statementRecords) {
            statement.append("\n");
            statement.append(statementRecord.date());
            statement.append("\t");
            if (statementRecord.value() >= 0) {
                statement.append("+");
            }
            statement.append(statementRecord.value());
            statement.append("\t\t");
            statement.append(statementRecord.balance());
        }
        statement.append("\n");
        return statement.toString();
    }
}
