#ifndef BINTREE_H
#define BINTREE_H
#include<stdlib.h>
#include<stdio.h>
#include<stdbool.h>
#define min(a, b) (((a) < (b)) ? (a) : (b))
#define max(a, b) (((a) > (b)) ? (a) : (b))

typedef struct Node * BinTree;

BinTree newBinTree(int element, BinTree left, BinTree right);
BinTree newLeaf(int element);

int size(BinTree t);
int height(BinTree t);
bool equals(BinTree t1, BinTree t2);
BinTree copy(BinTree t);
BinTree creaInc(BinTree t);
void incr(BinTree t);
BinTree copy_trimmed(int h, BinTree t);
void modify_trimmed(int h, BinTree * t);
BinTree modify_bookTrimmed(int h, BinTree t);
void dealloca(BinTree t);
#endif // BINTREE_H
