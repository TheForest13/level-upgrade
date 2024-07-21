package com.theforest.yandex;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 *
 * вадача
 * должен быть отказ (вид)
 * Баланс банкамата, идет списание
 */
@RequiredArgsConstructor
public class ATM {
    private final Balance balance;

    public Map<Nominal, Integer> deliveryCash(Integer queryCash) {
        // провека на вход (!null || queryCash==0) +
        // проверка баланса +
        // проверка на номинал +
        // списание
        // ответ

        if (queryCash == null || queryCash < 1) {
            throw new BusinessException("Запрашиваемая сумма не должна быть null или меньше 1");
        }

        if (queryCash > balance.getBalance()) {
            throw new BusinessException("Запрашиваемая сумма больше баланса банкомата");
        }

        if (queryCash % 50 != 0) { // подумать
            throw new BusinessException("Необходимого номанала в банкомате отсутсвует, " +
                    "просьба запросить сумму для номаналов: " + balance.getNominalToCount().keySet());
        }

        return balance.writeOff(queryCash);
    }

    public static void main(String[] args) {
//        Balance balance = new Balance()
    }
}

@Getter
class Balance {
    private Integer balance;

    private final Map<Nominal, Integer> nominalToCount;

    public Balance(Map<Nominal, Integer> nominalToCount) {
        this.nominalToCount = nominalToCount;
        this.balance = calculateBalance(nominalToCount);
    }

    public Map<Nominal, Integer> writeOff(int cash) {
        Map<Nominal, Integer> nominalToCountTemp = nominalToCount;
        Map<Nominal, Integer> nominalToCountFromClient = new HashMap<>();
        for (Map.Entry<Nominal, Integer> nominalEntry : nominalToCountTemp.entrySet()) {
            if (cash <= 0) {
                break;
            }
            if (cash % nominalEntry.getValue() == 0) {
                int nominal = nominalEntry.getKey().getValue();
                Integer countOff = cash / nominal;
                int countNominal = nominalEntry.getValue();
                if (countOff < countNominal) {
                    nominalToCountFromClient.put(nominalEntry.getKey(), countOff);
                    nominalEntry.setValue(countNominal - countOff);
                } else {
                    nominalToCountFromClient.put(nominalEntry.getKey(), countOff);
                    nominalEntry.setValue(0);
                }
                cash = cash - countOff * nominal;
            }
        }
        setBalance(calculateBalance(nominalToCountTemp));

        return nominalToCountFromClient;
    }

    private void setBalance(Integer balance) {
        this.balance = balance;
    }

    private int calculateBalance(final Map<Nominal, Integer> nominalToCount) {
        List<Integer> nominalValues = nominalToCount.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .toList();
        Integer balanceTemp = 0;
        for (Integer value : nominalValues) {
            balanceTemp += value;
        }
        return balanceTemp;
    }
}
