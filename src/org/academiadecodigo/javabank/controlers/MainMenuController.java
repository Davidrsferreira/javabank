package org.academiadecodigo.javabank.controlers;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.BalanceOperation;
import org.academiadecodigo.javabank.application.operations.NewAccountOperation;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.application.operations.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.domain.Bank;

import java.util.HashMap;
import java.util.Map;

public class MainMenuController extends Controller {

    private Map<Integer, Operation> operationsMap;

    public MainMenuController(Bank bank, int id, Prompt prompt) {
        super(bank, prompt);
        setAccessingCustomerId(id);
        operationsMap = buildOperationsMap();
        initializeViews();
    }

    @Override
    public void init() {

        super.init();

        int userChoice = view.getUserChoice();

        if (userChoice == UserOptions.QUIT.getOption()) {
            return;
        }

        operationsMap.get(userChoice).execute();
        init();
    }

    private Map<Integer, Operation> buildOperationsMap() {

        Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceOperation(this));
        map.put(UserOptions.DEPOSIT.getOption(), new DepositOperation(this));
        map.put(UserOptions.WITHDRAW.getOption(), new WithdrawOperation(this));
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new NewAccountOperation(this));

        return map;
    }

    private void initializeViews() {

    }
}
