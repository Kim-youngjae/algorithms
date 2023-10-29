| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞힌 사람 | 정답 비율 |
| --- | --- | --- | --- | --- | --- |
| 0.5 초 | 512 MB | 2573 | 1743 | 1490 | 69.077% |

## [문제](https://www.acmicpc.net/problem/20044)

코딩 프로젝트 수업을 가르치는 수찬이는 프로젝트 팀을 가능하면 공정하게 구성하려고 한다. 프로젝트 팀 하나는 두 명의 학생으로 구성되는데, 각 학생들의 코딩 역량은 모두 다르다. 각 학생은 한 팀의 팀원이어야 한다. 공정성을 높이기 위해 수찬이는 팀원 코딩 역량의 합을 최대한 일정하게 유지하려고 한다. 학생들이 코딩 역량이 주어졌을 때 수찬이가 팀을 구성하는데 도움이 되는 프로그램을 작성하라.

문제를 간단하게 하기 위해, 학생 수는 2*n*이라 가정하자 (*n*은 양의 정수). 각 학생 $*s_i*$의 코딩 역량은 양의 정수 $*w(s_i)*$로 나타내면 한 *i*번째 팀 *Gi*의 코딩 역량은 $*w(G_i) = ∑_{s∈G_i}w(s)*$로 나타낼 수 있다. 작성할 프로그램 목적은 $*S_m*$ = min{*w*($*G_i*$) | 1 ≤ *i* ≤ *n*}이 최대화되도록 *n*개의 팀 $*G_1, G_2, …, G_n*$ 을 구성하고 이때 $*S_m*$을 출력하는 것이다.

예를 들어, 학생들의 코딩 역량이 {1, 7, 5, 8}로 주어졌다면 (8, 1), (7, 5)로 2개의 조를 짤 수 있으며 프로그램은 9를 출력해야 한다.

## 입력

입력은 표준입력을 사용한다. 입력의 첫 번째 행에는 팀 수를 나타내는 양의 정수 *n*(1 ≤ *n* ≤ 5,000)이 주어진다. 그 다음 행에 학생 $*s_i*$ 의 코딩 역량 *w*($*s_i*$)를 나타내는 2*n*개의 양의 정수가 공백으로 분리되어 주어진다 (1 ≤ *w*($*s_i*$) ≤ 100,000). 학생들의 코딩 역량은 모두 다르다. 즉, *i* ≠ *j*이면 *w*($*s_i*$) ≠ *w*($*s_j*$)이다.

## 출력

출력은 표준출력을 사용한다. 표준출력 한 행에 $*S_m*$을 출력한다.

## 예제 입력 1

```
2
1 7 5 8

```

## 예제 출력 1

```
9

```

## 예제 입력 2

```
3
1 7 3 5 9 2

```

## 예제 출력 2

```
8
```

두 명씩 한 팀을 짤 때에 한 팀의 코딩 역량 값들 중 제일 작은 값이 제일 최대가 되게 하는 조합을 찾는 것이다.

1, 7, 5, 8의 코딩 역량을 가진 학생들이 있을 때

- (1, 7) (5, 8) → 8 13
- (1, 5) (7, 8) → 6 15
- (1, 8) (5, 7) → 9 12

팀의 코딩 역량 값 조합 중 제일 작은 값이 최대인 경우의 조합은 (1, 8) (5, 7) 일 때이다.

제일 작은 코딩 역량 , 제일 큰 코딩 역량이 짝을 이룰 때가 제일 코딩 역량이 작으면서 조합들 중 최대가 된다.

**성공 코드**

```java
package com.baekjoon.p20044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/20044

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> projectTeams = new ArrayList<>();
        List<Integer> projectWeights = new ArrayList<>();

        int n = Integer.valueOf(br.readLine());
        String[] bits = br.readLine().split(" ");

        for (String s : bits) {
            projectTeams.add(Integer.valueOf(s));
        }

        Collections.sort(projectTeams); // 오름 차순 정렬

        for (int i = 0; i < n; i++) { // 절반까지만 반복
            int sumOfProjectWeight = projectTeams.get(i) + projectTeams.get((2 * n - 1) - i);
            projectWeights.add(sumOfProjectWeight);
        }

        System.out.println(Collections.min(projectWeights)); // 프로젝트 팀 중 가장 역량의 합이 제일 작은 팀을 출력
    }
}
```

### 복습

성공코드

```java
package com.baekjoon.p20044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> ability = new ArrayList<>();

        int sum = Integer.MAX_VALUE;
        int temp = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 첫번째 입력
        String[] strArr = br.readLine().split(" ");// 두번째 입력

        int lastIndex = (n * 2) - 1;

        for (int i = 0; i < strArr.length; i++)
        {
            ability.add(Integer.valueOf(strArr[i]));
        }

        Collections.sort(ability);

        for (int i = 0; i < ability.size(); i++)
        {
            if (lastIndex == n - 1) break;

            temp = ability.get(i) + ability.get(lastIndex);

            if (temp <= sum)
            {
                sum = temp;
            }

            lastIndex--;
        }

        System.out.println(sum);
    }
}
```