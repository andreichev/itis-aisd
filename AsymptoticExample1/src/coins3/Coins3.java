package coins3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    static Variant getMinSize(List<Variant> variants) {
        if(variants.size() == 0) { return null; }
        Variant result = variants.get(0);
        for(Variant variant: variants) {
            if(variant.coins.length < result.coins.length) {
                result = variant;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int sum = 987;
        Variant[] variants = new Variant[sum + 1];
        variants[0] = new Variant(new int[] {});
        variants[1] = new Variant(new int[] {1});
        List<Variant> tempVariants = new ArrayList<>();
        for(int i = 2; i <= sum; i++) {
            tempVariants.clear();
            if(i == 5) {
                tempVariants.add(new Variant(new int[]{5}));
            }
            if(i == 10) {
                tempVariants.add(new Variant(new int[]{10}));
            }
            if(i == 20) {
                tempVariants.add(new Variant(new int[]{20}));
            }
            if(i == 25) {
                tempVariants.add(new Variant(new int[]{25}));
            }
            if(i == 50) {
                tempVariants.add(new Variant(new int[]{50}));
            }
            tempVariants.add(variants[i - 1].getVariantAddingCoin(1));
            if(i > 5) {
                tempVariants.add(variants[i - 5].getVariantAddingCoin(5));
            }
            if(i > 10) {
                tempVariants.add(variants[i - 10].getVariantAddingCoin(10));
            }
            if(i > 20) {
                tempVariants.add(variants[i - 20].getVariantAddingCoin(20));
            }
            if(i > 25) {
                tempVariants.add(variants[i - 25].getVariantAddingCoin(25));
            }
            if(i > 50) {
                tempVariants.add(variants[i - 50].getVariantAddingCoin(50));
            }
            variants[i] = getMinSize(tempVariants);
        }

        System.out.println(variants[sum]);
    }
}
