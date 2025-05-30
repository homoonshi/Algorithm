# [Gold II] 시설물 사용 신청 - 32990 

[문제 링크](https://www.acmicpc.net/problem/32990) 

### 성능 요약

메모리: 449708 KB, 시간: 1284 ms

### 분류

해 구성하기, 수학

### 제출 일자

2025년 1월 4일 16:55:36

### 문제 설명

<p>경기과학고에서는 시설물 사용 신청 제도를 통해 강의실을 빌려서 공부할 수 있다. 시설물 사용을 신청하려면, 시설물을 사용하고자 하는 시간대의 시작 시각과 종료 시각을 명시해야 한다. 이때 사용 시작 시각 $s$와 종료 시각 $e$는 모두 $N$ 이하의 양의 정수여야 하며, $s<e$를 만족해야 한다. 이때 이 학생이 시설물을 사용하는 시간대를 $(s,e)$로 표현하자.</p>

<p>서로 다른 두 학생이 한 강의실을 같은 시간대에 사용할 수 없다. 예를 들어, 두 학생이 각각 시간대 $(2,4)$와 $(3,5)$에 시설물 사용을 신청했다면 시간대 $(3,4)$가 겹치므로 이 두 학생을 같은 강의실에 배정할 수 없다. 단, 한 학생의 시설물 사용 종료 시각과 다른 학생의 사용 시작 시각은 같을 수 있다. 예를 들어, 두 학생이 각각 시간대 $(2,4)$와 $(4,5)$에 신청했다면 두 학생은 같은 강의실에 배정할 수 있다.</p>

<p>오늘은 매우 많은 학생들이 시설물 사용을 신청했는데, $1 \leq i < j \leq N$인 모든 순서쌍 $(i, j)$에 대해 시간대 $(i,j)$에 정확히 한 건씩의 신청이 들어왔다. 시설물 사용 신청 시스템의 운영자인 여러분은, 사용되는 강의실의 수가 최소가 되게끔 각 신청 건을 강의실에 배정해야 한다.</p>

<p>필요한 최소 강의실이 몇 개인지, 이때 각 신청 건을 어떤 강의실에 배정해야 하는지 구해보자.</p>

### 입력 

 <p>첫 번째 줄에 양의 정수 $N$이 주어진다.</p>

### 출력 

 <p>첫 번째 줄에 필요한 강의실의 최소 개수 $M$을 출력하여라.</p>

<p>$M \leq 1\,000\,000$이라면, 두 번째 줄부터 $M$개의 줄 중 $i$번째 줄에, $i$번째 강의실에 배정할 신청 건의 수 $X_i$와 $X_i$개 신청 건 각각에 대한 사용 시간대의 시작 시각과 종료 시각 $s$와 $e$를 공백으로 구분하여 출력하여라. 단, $X_i > 0$이어야 한다.</p>

<p>가능한 방법이 여러 가지라면, 그중 아무것이나 출력하여라.</p>

<p>$M > 1\,000\,000$이라면 $M$만 출력하여라.</p>

