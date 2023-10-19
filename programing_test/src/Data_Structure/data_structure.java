package Data_Structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Sort{
	
	//삽입정렬
	static class Insert_sort{
		static Sort A = new Sort();
		
		public void insert_sort(int[] a) {
			insert_sort(a, a.length);
		}
		private static void insert_sort(int[] a ,int size) {
			for(int i = 1; i < size; i++) {
				int target_idx = i;
				
				while(target_idx != 0) {
					if(a[target_idx] < a[target_idx - 1]) {
						int temp = a[target_idx - 1];
						a[target_idx - 1] = a[target_idx];
						a[target_idx] = temp;
						
						target_idx--;
					}
					else {
						break;
					}
				}
				A.printArr(a);
			}
		}
	}
	
	//선택정렬
	static class Selection_sort{
		static Sort A = new Sort();
		public void selection_sort(int[] a) {
			selection_sort(a, a.length);
		}
		private static void selection_sort(int[] a, int size) {
			for(int i = 0; i < a.length - 1; i++) {
				int min_idx = i;
				for(int j = i + 1; j < a.length; j++) {	//min_value searching
					if(a[min_idx] > a[j]) {
						min_idx = j;	//find min_value
					}
				}
				//Change process
				int temp = a[min_idx];
				a[min_idx] = a[i];
				a[i] = temp;
				
				A.printArr(a);
			}
		}
	}
	
	//병합정렬
	static class Merge_sort{
		static Sort A = new Sort();
		
		private static int[] sorted;	//Temp_arr
		
		public void merge_sort(int[] a) {
			sorted = new int[a.length];
			merge_sort(a, 0, a.length - 1);
		}
		
		private void merge_sort(int[] a, int left, int right) {
			if(left == right)	
				return;
			
			int middle = (left + right) /2;
			
			merge_sort(a, left, middle);	
			merge_sort(a, middle + 1, right);	
			
			merge(a, left, middle, right);	
			
		}
		
		private void merge(int[] a, int left, int middle, int right) {
			int l_idx = left;
			int r_idx = middle + 1;
			int index = left;
			
			
			while(l_idx <= middle && r_idx <= right) {
				if(a[l_idx] <= a[r_idx]) {	
					sorted[index] = a[l_idx];	
					l_idx++;
					index++;
				}
				else {
					sorted[index] = a[r_idx];
					index++;
					r_idx++;
				}
			}
			
			if(l_idx > middle) {
				while(r_idx <= right) {
					sorted[index] = a[r_idx];
					index++;
					r_idx++;
				}
			}
			else {
				while(l_idx <= middle) {
					sorted[index] = a[l_idx];
					index++;
					l_idx++;
				}
			}
			
			for(int i = left; i <= right; i++) {
				a[i] = sorted[i];
			}
			A.printArr(a);	
		}
	}
	//퀵 정렬 
	static class Quick_sort{
		static Sort A = new Sort();
		
		public void quick_sort(int[] a) {
			quick_sort(a, 0, a.length - 1);
		}
		
		private void quick_sort(int[] a, int left, int right) {
			if(left >= right) {
				return;
			}
			
			int div = partition(a, left, right);
			quick_sort(a, left, div - 1);
			quick_sort(a, div + 1, right);
		
		}
		
		private int partition(int[] a, int start, int end) {
			int pivot = start;
			int left = start;
			int right = end;
			
			int temp;
			
			while(left < right) {
				while((a[right] > a[pivot]) && (left < right)) {
					right--;
				}
				while((a[left] <= a[pivot]) && (left < right)) {
					left++;
				}
				
				temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				
			}
			
			temp = a[start];
			a[start] = a[left];
			a[left] = temp;
			
			A.printArr(a);
			
			return left;
		}		
	}
	//버킷정렬
	static class Bucket_sort{
		static Sort A = new Sort();
		
		public void bucket_sort(int[] a) {
			bucket_sort(a, a.length - 1);
		}
		
		private void bucket_sort(int[] a, int size) {
			List<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
			
			for(int i = 0; i < size; i++) {
				bucket.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < size; i++) {
				int idx = (int)(a[i]% 10);
				bucket.get(idx).add(a[i]);	
			}
			
			for(int i= 0; i < size; i++){
	            Collections.sort(bucket.get(i));
	        }
			
			int index = 0;
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < bucket.get(i).size(); j++) {
					a[index++] = bucket.get(i).get(j);
				}
			}
			
			A.printArr(a);
			
		}
	}
	//출력
	public void printArr(int[] A) {
		System.out.printf("변환 과정 : ");
		for(int i : A) {
			System.out.printf("%d ", i);
		}
		System.out.println();
	}
}

class Search{
	//순차탐색
	static class Sequential_Search{
		public void sequntial_search(int[] A) {
			System.out.println("Number : ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			boolean result = false;
			
			for(int i : A) {
				if(input == i) {
					result = true;
				}
			}
			
			if(result) {
				System.out.println("Find");
			}
			else {
				System.out.println("Cannot Exist");
			}
			
			sc.close();
		}
	}
	//이진탐색
	static class Binary_Search{
		public void binary_search(int[] A) {
			System.out.printf("List : ");
			for(int i : A) {
				System.out.printf("%d ", i);
			}
			System.out.println();
			System.out.printf("Number : ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			sc.close();
			
			Arrays.sort(A);
			
			
			
			int result = binary_search(A, input);
			
			if(result != -1) {
				System.out.println(input + " Find");
			}
			else {
				System.out.println(input + " Cannot Exist");
			}
		}
		
		private int binary_search(int[] A, int input) {
			
			int mid;
			int start = 0;
			int end = A.length - 1;
			
			while(start <= end) {
				mid = (start + end) / 2;
				
				if(input == A[mid]) {
					return mid;
				}
				
				if(input < A[mid]) {
					end = mid - 1;
				}
				else {
					start = mid + 1;
				}
				
			}
			return -1;
		}
	}
}

//이진트리
class BST{
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int element) {
			this.data = element;
			this.left = null;
			this.right = null;
		}
	}
	
	Node root = null;
	
	//노드 삽입 
	public void insertNode(int element) {
		Node newnode = new Node(element);
		
		if(root == null) {
			root = newnode;
		}
		else {
			Node head = root;
			Node temp;
			
			while(true) {
				temp = head;
				
				if(head.data > element) {
					head = head.left;
					if(head == null) {
						temp.left = newnode;
						break;
					}
				}
				else {
					head = head.right;
					if(head == null) {
						temp.right = newnode;
						break;
					}
				}
			}	
		}
	}
	
	//노드 제거
    public void deletion(int element) {
        Node removeNode = root;
        Node parentOfRemoveNode = null;

        while (removeNode.data != element) {
            parentOfRemoveNode = removeNode;

            if (removeNode.data > element) {
                removeNode = removeNode.left;
            } else {
                removeNode = removeNode.right;
            }

            if (removeNode == null)
                System.out.println("Search_Fail");

        }

        // 자식 없음 
        if (removeNode.left == null && removeNode.right == null) {
            if (removeNode == root) {
                root = null;
            } else if (removeNode == parentOfRemoveNode.right) {
                parentOfRemoveNode.right = null;
            } else {
                parentOfRemoveNode.left = null;
            }
        }
        //오른쪽 자식만 존재
        else if (removeNode.left == null) {
            if (removeNode == root) {
                root = removeNode.right;
            } else if (removeNode == parentOfRemoveNode.right) {
                parentOfRemoveNode.right = removeNode.right;
            } else {
                parentOfRemoveNode.left = removeNode.right;
            }
        }
        //왼쪽 자식만 존재
        else if (removeNode.right == null) {
            if (removeNode == root) {
                root = removeNode.left;
            } else if (removeNode == parentOfRemoveNode.right) {
                parentOfRemoveNode.right = removeNode.left;
            } else {
                parentOfRemoveNode.left = removeNode.left;
            }
        }
        //자식 2개 존재 
        else {
            Node parentOfReplaceNode = removeNode;

            Node replaceNode = parentOfReplaceNode.right;
            
            //find exist node
            while (replaceNode.left != null) {
                parentOfReplaceNode = replaceNode;
                replaceNode = replaceNode.left;
            }

            if (replaceNode != removeNode.right) {
                parentOfReplaceNode.left = replaceNode.right;

                replaceNode.right = removeNode.right;
            }

            if (removeNode == root) {
                root = replaceNode;
            } else if (removeNode == parentOfRemoveNode.right) {
                parentOfRemoveNode.right = replaceNode;
            } else {
                parentOfRemoveNode.left = replaceNode;
            }

            replaceNode.left = removeNode.left;
        }

    }
	
	public void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
				
		}
	}
		
	public void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data);
		}
	}
		
	public void preorder(Node root) {
		if(root != null) {
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
}

class Graph{
	class Node{
		int vertex;
		int cost;
		boolean marked;
		
		Node (int vertex, int cost){
			this.vertex = vertex;
			this.cost = cost;
			this.marked = false;
		}

		public int getVertex() {
			return this.vertex;
		}
		
		public int getCost() {
			return this.cost;
		}
	}
	
	List<ArrayList<Node>> adlist;
	int size;
	boolean visit[];
	private int maps[][];	//최소경로구하기 위해 사용됨 
	
	Graph(int initsize){
		adlist = new ArrayList<ArrayList<Node>>();
		visit = new boolean[initsize];
		this.size = initsize;
		maps = new int[initsize][initsize];
		
		for(int i = 0; i < initsize; i++) {
			for(int j = 0; j < initsize; j++) {
				maps[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i < initsize; i++) {
			this.adlist.add(new ArrayList<Node>());
		}
	}
	
	//그래프 입력 
	public void put(int start, int dest, int weight) {
		maps[start][dest] = weight;
		maps[dest][start] = start;
		this.adlist.get(start).add(new Node(dest, weight));
		this.adlist.get(dest).add(new Node(start, weight));
	}
	
	//그래프 출력
	public void printgraph(int startidx) {
		for(int i = startidx; i < size; i++) {
			System.out.printf("%d : ", i);
			for(int j = 0;  j < adlist.get(i).size(); j++) {
				System.out.printf("%d ", this.adlist.get(i).get(j).getVertex());
			}
			System.out.println();
		}
	}
	
	//깊이 우선 탐색 
	public void dfs(Graph root, int index) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < visit.length -1; i++) {
			visit[i] = false;
		}
		stack.push(index);
		visit[index] = true;
		
		while(!stack.isEmpty()) {
			int r = stack.pop();

			System.out.printf("%d ", r);
			for(Node i : root.adlist.get(r)) {
				int vertexNum = i.getVertex();
				
				if(visit[vertexNum] == false) {
					visit[vertexNum] = true;
					stack.add(vertexNum);
				}
			}
		}
		System.out.println();
	}
	
	//너비 우선 탐색
	public void bfs(Graph root, int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		
		for(int i = 0; i < visit.length -1; i++) {
			visit[i] = false;
		}
		
		visit[index] = true;
		
		while(!queue.isEmpty()) {
			int r = queue.poll();
			System.out.printf("%d ", r);
			
			for(Node n: root.adlist.get(r)) {
				int vertexNum = n.getVertex();
				if(visit[vertexNum] == false) {
					visit[vertexNum] = true;
					queue.add(vertexNum);
				}  
			}
		}
		
		System.out.println();
	}
	
	//최소경로 탐색
	public void Shortest_Path(int v) {
		int distance[] = new int[size];

		for(int i=0; i<size; ++i){
            distance[i] = Integer.MAX_VALUE;
        }
         
        distance[v] = 0;
        visit[v] = true;
        
        for(int i=0; i<size; ++i){
        	if(distance[i] == 2147483647) System.out.print("INF ");
        	else System.out.print(distance[i]+" ");
        }
        System.out.println("");
         
        for(int i=0; i<size; ++i){
            if(!visit[i] && maps[v][i] != Integer.MAX_VALUE){
                distance[i] = maps[v][i];
            }
        }
        
        for(int i=0; i<size; ++i){
        	if(distance[i] == 2147483647) System.out.print("INF ");
        	else System.out.print(distance[i]+" ");
        }
        System.out.println("");
         
        for(int a=0; a<size-1; ++a){
            int min = Integer.MAX_VALUE;
            int min_index = 0;
            
            for(int i=0; i<size; ++i){
                if(!visit[i]){
                    if(distance[i] < min){
                        min = distance[i];
                        min_index = i;
                    }
                }
            }
            
            visit[min_index] = true;
            for(int i=0; i<size; ++i){
                if(!visit[i] && maps[min_index][i] != Integer.MAX_VALUE){
                    if(distance[min_index] + maps[min_index][i] < distance[i]){
                        distance[i] = distance[min_index] + maps[min_index][i];
                    }
                }
            }
            
            for(int i=0; i<size; ++i){
            	if(distance[i] == 2147483647) System.out.print("INF ");
            	else System.out.print(distance[i]+" ");
            }
            System.out.println("");
        }
	}
	
	//최대경로 탐색을 위해 사용하는 위상정렬
	private void topologicalSortUtil(int v, boolean visit[], Stack<Integer> stack) {	
		visit[v] = true;
		// 이 정점에 인접한 모든정점에 대해 반복함 
		for (int i = 0; i<adlist.get(v).size(); i++) {
			Node node = adlist.get(v).get(i);
			if (!visit[node.getVertex()])
				topologicalSortUtil(node.getVertex(), visit, stack);
			}
		// 현재 정점을 위상정렬스텍에 넣는과정을 거쳐서 위상정렬이 되도록 
		
		stack.push(v);
		}
	
	//최대거리를 얻는함수
	public void longestPath(int s) {
		Stack<Integer> stack = new Stack<Integer>();
		int dist[] = new int[size];

		for (int i = 0; i < size; i++)
			visit[i] = false;

		// 위상정렬 함수를 호출하여, 그래프의 노드가 정렬되게 한다. 
		for (int i = 0; i < size; i++)
			if (visit[i] == false)
				topologicalSortUtil(i, visit, stack);

		// 거리 초기화 단계 
		for (int i = 0; i < size; i++)
			dist[i] = Integer.MIN_VALUE;

		dist[s] = 0;

		// 위상정렬 된 순서대로, 거리 계산한다 
		while (stack.isEmpty() == false) {
			
			int u = stack.peek();
			stack.pop();

			if (dist[u] != Integer.MIN_VALUE) {
				for (int i = 0; i< adlist.get(u).size(); i++) {
					 Node node = adlist.get(u).get(i);
					if (dist[node.getVertex()] < dist[u] + node.getCost());
						dist[node.getVertex()] = dist[u] + node.getCost();
				}
			}
		}
		
		
		for (int i = 0; i < size; i++)
			if(dist[i] == Integer.MIN_VALUE)
				System.out.print("INF ");
			else
				System.out.print(dist[i] + " ");
	}
}

//최장거리 코드는 "https://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/" 참조하여 작성했습니다.


	
	


public class data_structure {
	private static int[] random(int size) {	//정렬, 서칭 과정에서 사용하는 랜덤함수
	int[] arr = new int[10];
	
	for(int i = 0; i < 10; i++) {
		arr[i] = (int)(Math.random() * 100); 
	}
	
	return arr;
	}
	
	public static void main(String[] args) {
		/*
		int[] A = new int[10];
		A = random(A.length);
		Sort.Bucket_sort B = new Sort.Bucket_sort();
		B.bucket_sort(A);
		*/
		
        Graph graph = new Graph(9);
        
        graph.put(0, 1, 7);
        graph.put(0, 2, 9);
        graph.put(0, 5, 14);
        graph.put(1, 2, 10);
        graph.put(1, 3, 15);
        graph.put(2, 3, 11);
        graph.put(2, 5, 2);
        graph.put(3, 4, 6);
        graph.put(4, 5, 9);
        
        graph.longestPath(0);
        
        
	}

}