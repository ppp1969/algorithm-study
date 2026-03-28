✅ Solved Problems
 Problem 1 - 9012 괄호
 Problem 2 - 4949 균형잡힌 세상
 Problem 3 - 5397 키로거
 Problem 4 - 1406 에디터 

🧩 Problem 1

🚀 접근법

짝 맞추기니까 스택을 사용해서 시뮬레이션하면 O(N) 에 풀릴 것 같다. 

📝 기억하고 싶은 점

없음 

🧩 Problem 2 

🚀 접근법

짝 맞추기니까 스택을 사용해서 시뮬레이션하면 O(N) 에 풀릴 것 같다. 

📝 기억하고 싶은 점

없음 

🧩 Problem 3

🚀 접근법

일단 배열에 넣어서 시뮬레이션 해볼까 ? 
근데 그러면 , 화살표를 이동시키고 하나 지우면 전부 옮겨야 한다. 
그러면 O(N^2) 이 되는데 , L 은 100만 이하니까 시간 초과가 날 것이다. 
양끝이 아닌 부분에 삽입과 삭제시 , 최적화할 수 있는 자료구조 어떤게 있을까 ? 
LinkedList 를 써보자 ! 

📝 기억하고 싶은 점

C++ 에서 많이 쓰이는 Iterator가 Java 에도 있다 ! 
ListIterator<Character> iter = list.listIterator();

반복자로 쓸 수 있는 함수에는 다음이 있다. 
iter.hasNext() 
iter.next() 
iter.add(element)
iter.hasPrevious()
iter.previous()
iter.remove() 

LinkedList 사용시 
일반 for 문 - list.get(i) -> O(N^2)
향상된 for문 - for(char c : list) -> Iterator 사용 -> O(N)



🧩 Problem 4 

🚀 접근법

3번 문제와 동일 

📝 기억하고 싶은 점

3번 문제와 동일 


