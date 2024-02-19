package com.example.binhdv35.count_vns;

import java.util.HashSet;
import java.util.Set;

public class CountVnCharaters {
    public int count(String strInput, String[] myArray) {
        Set<String> stringSet = new HashSet<>();

        int count = 0;

        // Duyệt qua mảng các chuỗi
        for (String str : myArray) {
            // Nếu chuỗi con đã xuất hiện, không cần kiểm tra lại tiếp tục vòng for
            if (stringSet.contains(str)) {
                continue;
            }

            // Tìm vị trí xuất hiện đầu tiên của chuỗi con trong chuỗi đầu vào
            int index = strInput.indexOf(str);

            if (index != -1) {
                // Tăng biến đếm và thêm chuỗi con vào Set nếu tìm thấy
                count++;
                stringSet.add(str);
            }
        }
        return count;
    }
}
