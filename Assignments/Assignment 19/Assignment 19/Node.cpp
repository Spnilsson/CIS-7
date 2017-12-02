#include "Node.h"

Node::Node()
{
	key = -1;
	left = nullptr;
	right = nullptr;
	nodeNum++;
}

Node::Node(int key)
{
	this->key = key;
	left = nullptr;
	right = nullptr;
	nodeNum++;
}

Node::~Node()
{
}

inline void Node::setKey(int aKey)
{
	key = aKey;
}

inline void Node::setLeft(Node * aLeft)
{
	left = aLeft;
}

inline void Node::setRight(Node * aRight)
{
	right = aRight;
}

inline int Node::getKey()
{
	return key;
}

inline Node * Node::getLeft()
{
	return left;
}

inline Node * Node::getRight()
{
	return right;
}

int Node::getNodeNum()
{
	return nodeNum;
}
