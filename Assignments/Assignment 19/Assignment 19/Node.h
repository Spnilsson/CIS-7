#include <iostream>

class Node
{
public:
	Node();
	Node(int key);
	~Node();
	void setKey(int aKey);
	void setLeft(Node * aLeft);
	void setRight(Node * aRight);
	int getKey();
	Node * getLeft();
	Node * getRight();
	int getNodeNum();
	
private:
	int key;
	Node * left;
	Node * right;
	int nodeNum = 0;
};


