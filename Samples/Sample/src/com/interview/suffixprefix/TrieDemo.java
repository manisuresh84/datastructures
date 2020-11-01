package com.interview.suffixprefix;

public class TrieDemo {

	public TrieDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		t.insert("suresh");
		t.insert("sureka");
		t.insert("sai");
		
		System.out.println("Search \"suresh\" exists in Trie :" + t.search("suresh"));
		System.out.println("Search \"sur\" exists in Trie :" + t.search("sur"));
	}

}
