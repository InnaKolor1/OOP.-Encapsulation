
package org.skypro.skyshop.Utilities;
import org.skypro.skyshop.exception.BestResultNotFound;

import javax.swing.text.Utilities;

public class ArrayUtil {

    public static <S> int getIndex(S[] array, boolean findNull) {
        for (int i = 0; i < array.length; i++) {
            if (findNull ? array[i] == null : array[i] != null) {
                return i;
            }
        }
        return -1;
    }
}

