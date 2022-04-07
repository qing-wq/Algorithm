package 蓝桥;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 错误票据 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();  // 去掉换行符！！！
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            for (String s : arr) {
                list.add(Integer.parseInt(s));
            }
        }
        Collections.sort(list);
        int M = 0,N =0;
        int s = 0,f = 1;
        while (f < list.size()) {
            if (list.get(s) == list.get(f)) {
                N = list.get(s);
            }
            if (list.get(f) == list.get(s) + 2) {
                M = list.get(f) -1;
            }
            s++;
            f++;
        }
        System.out.println(M + " " + N);


        /*6
164 178 108 109 180 155 141 159 104 182 179 118 137 184 115 124 125 129 168 196
172 189 127 107 112 192 103 131 133 169 158
128 102 110 148 139 157 140 195 197
185 152 135 106 123 173 122 136 174 191 145 116 151 143 175 120 161 134 162 190
149 138 142 146 199 126 165 156 153 193 144 166 170 121 171 132 101 194 187 188
113 130 176 154 177 120 117 150 114 183 186 181 100 163 160 167 147 198 111 119*/

    }
}
