package BlackJack;

import java.util.HashMap;

// ScoreTable.java
public class ScoreTable {
    private HashMap<String, int[]> table = new HashMap<>();
    
    public void Table_Create(String rank,int score) { // ���̺� ���� �޼ҵ�
    	String key = rank;
    	int[] value = new int[1];
    	value[0] = score; 
    	table.put(key,value);
    }
    	
    ScoreTable(){
    //(F) key=��ũ: value=���� ���� ���̺��� �����Ѵ�.
    	    	
    	String key = "A"; // "A"�� ��� ���� ����
    	int[] value = new int[2];
    	value[0]=1; 
    	value[1]=11;
    	table.put(key,value);
    	
    	Table_Create("2",2);
    	Table_Create("3",3);
    	Table_Create("4",4);
    	Table_Create("5",5);
    	Table_Create("6",6);
    	Table_Create("7",7);
    	Table_Create("8",8);
    	Table_Create("9",9);
    	Table_Create("10",10);
    	Table_Create("J",10);
    	Table_Create("Q",10);
    	Table_Create("K",10);   	
    }
    
    public int[] score(Card card) {
    //(G) card �� ������ �����Ѵ�. A�� ��� 1 �Ǵ� 11�̸�, �� ��쿡 �ش� ������� ������ length�� 2�� �����迭�� ���ϵȴ�.
                
        if (card.getRank().equals("A")) { // "A"�� ��� ���� ����
            int[] value = new int[2];
            value[0] = 1;
            value[1] = 11;
            return value;
        }
        else {
        	int[] value = new int[1];
        	value = table.get(card.getRank()); // ī���� rank�� �ش��ϴ� ���ڷ� �ٲٴ� ����
            return value;
        }		
    }
}