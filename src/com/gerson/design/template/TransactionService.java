package com.gerson.design.template;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/29.
 */
public class TransactionService {
    private TransactionTemplate transactionTemplate;

    public TransactionService(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public Integer service() {
        return transactionTemplate.execute(new Executor<Integer>() {
            @Override
            public Integer execute() {
                return null;
            }
        });
    }
}
