#include "Node.h"
#include <vector>

int menu();
void inOrder(Node * n);
void preOrder(Node * n);
void postOrder(Node * n);
void addLeftChild();
void addRightChild();
int depth(Node * n);
bool isFull(Node * n);

Node * root = new Node(0);
std::vector <Node *> nodes;


int main() {
	
	nodes.push_back(root);

	int choice = 0;
	do {
		choice = menu();
	} while (choice != 3);

	return 0;
}


int menu()
{

	int choice = 0;
	std::cout << "There are " << root->getNodeNum << " number of nodes." << std::endl
		<< "The depth of the tree is " << depth(root) << std::endl
		<< "Preorder: " << preOrder(root) << std::endl
		<< "Postorder: " << postOrder(root) << std::endl
		<< "Inorder: " << inOrder(root) << std::endl << std::endl;
	std::cout << "1. Create a left child \n2. Create a right child\n3. Quit\n";
	std::cout << "Enter your choice: ";
	std::cin >> choice;

	switch (choice) {
	case 1:
		addLeftChild();
		break;
	case 2:
		addRightChild();
		break;
	case 3:
		return choice;
	}

	return choice;
}

void inOrder(Node* n) {
	if (n) {
		inOrder(n->getLeft());
		std::cout << n->getKey() << " ";
		inOrder(n->getRight());
	}
}

void preOrder(Node* n) {
	if (n) {
		std::cout << n->getKey() << " ";
		preOrder(n->getLeft());
		preOrder(n->getRight());
	}
}

void postOrder(Node * n)
{
	if (n) {
		postOrder(n->getLeft());
		postOrder(n->getRight());
		std::cout << n->getKey() << " ";
	}
}

Node * findNode(int key) {
	for (auto nodeptr : nodes) {
		if (nodeptr->getKey() == key) {
			return nodeptr;
		}
	}
}

void addLeftChild()
{
	int key;
	int key2;
	std::cout << "Enter the number of the node you wish to add as a left child: ";
	std::cin >> key;
	std::cout << "\nEnter the number of the node you wish to have as the parent of the left child (0 for root): ";
	std::cin >> key2;

	Node * n = new Node(key);
	Node * nodePoint = findNode(key2);
	nodePoint->setLeft(n);
	
}

void addRightChild()
{
	int key;
	int key2;
	std::cout << "Enter the number of the node you wish to add as a left child: ";
	std::cin >> key;
	std::cout << "\nEnter the number of the node you wish to have as the parent of the left child (0 for root): ";
	std::cin >> key2;

	Node * n = new Node(key);
	Node * nodePoint = findNode(key2);
	nodePoint->setRight(n);

}

int depth(Node * n)
{
	if (n == NULL) {
		return 0;
	}

	int lDepth = depth(n->getLeft);
	int rDepth = depth(n->getRight);

	if (lDepth > rDepth) {
		return lDepth + 1;
	}
	else {
		return rDepth + 1;
	}
}

bool isFull(Node * n)
{
	if (n->getLeft == NULL && n->getRight == NULL ) {
		return true;
	}
	else if (n->getLeft != NULL && n->getRight != NULL) {
		return (isFull(n->getLeft) && n->getRight);
	}

	return false;
}
	