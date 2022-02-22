package coins3;

import java.util.Arrays;

public class Coins3 {
    static class Variant {
        int[] coins;

        public Variant(int[] coins) {
            this.coins = coins;
        }

        Variant getVariantAddingCoin(int coinValue) {
            int[] nCoins = new int[coins.length + 1];
            System.arraycopy(coins, 0, nCoins, 0, coins.length);
            nCoins[coins.length] = coinValue;
            return new Variant(nCoins);
        }

        @Override
        public String toString() {
            return Arrays.toString(coins);
        }
    }

    static Variant getMinSize(Variant[] variants) {
        if(variants.length == 0) { return null; }
        Variant result = variants[0];
        for(Variant variant: variants) {
            if(variant.coins.length < result.coins.length && variant.coins.length != 0) {
                result = variant;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int sum = 42;
        Variant[] variants = new Variant[sum + 1];
        variants[0] = new Variant(new int[] {});
        variants[1] = new Variant(new int[] {1});
        Variant[] tempVariants = new Variant[6];
        for(int i = 2; i <= sum; i++) {
            if(i == 5) {
                variants[i] = new Variant(new int[]{5});
                continue;
            }
            if(i == 10) {
                variants[i] = new Variant(new int[]{10});
                continue;
            }
            if(i == 20) {
                variants[i] = new Variant(new int[]{20});
                continue;
            }
            if(i == 25) {
                variants[i] = new Variant(new int[]{25});
                continue;
            }
            if(i == 50) {
                variants[i] = new Variant(new int[]{50});
                continue;
            }
            for (int j = 0; j < 6; j++) {
                tempVariants[j] = new Variant(new int[] {});
            }
            tempVariants[0] = variants[i - 1].getVariantAddingCoin(1);
            if(i > 5) {
                tempVariants[1] = variants[i - 5].getVariantAddingCoin(5);
            }
            if(i > 10) {
                tempVariants[2] = variants[i - 10].getVariantAddingCoin(10);
            }
            if(i > 20) {
                tempVariants[3] = variants[i - 20].getVariantAddingCoin(20);
            }
            if(i > 25) {
                tempVariants[4] = variants[i - 25].getVariantAddingCoin(25);
            }
            if(i > 50) {
                tempVariants[5] = variants[i - 50].getVariantAddingCoin(50);
            }
            variants[i] = getMinSize(tempVariants);
        }

        System.out.println(variants[sum]);
    }
}
