#include "bintree.h"

struct Node{
    int element;
    BinTree left;
    BinTree right;
};

BinTree newBinTree(int element, BinTree left, BinTree right)
{
    BinTree p = (BinTree)malloc(sizeof(struct Node));
    p->element = element;
    p->left=left;
    p->right =right;
    return p;
}

BinTree newLeaf(int element)
{
    BinTree p = (BinTree)malloc(sizeof(struct Node));
    p->element = element;
    p->left = NULL;
    p->right = NULL;
    return p;
}

int size(BinTree t)
{
    return (!t) ?  0 : size(t->left)+size(t->right)+1;
}

int height(BinTree t)
{
    return (!t) ? -1 : 1 + max(height(t->left),height(t->right));
}

bool equals(BinTree t1, BinTree t2)
{
    return (t1==t2 || ( t1 && t2 && t1->element == t2->element && equals(t1->left,t2->left) && equals(t1->right, t2->right )  ) ) ? true : false;
}

BinTree copy(BinTree t)
{
    return !t ? NULL : newBinTree(t->element, t->left , t->right);
}

BinTree creaInc(BinTree t)
{
    return !t ? NULL : newBinTree(t->element + 1 , creaInc(t->left) , creaInc(t->right));
}

void incr(BinTree t)
{
    if(t == NULL)
        return;
    t->element ++;
    incr(t->left);
    incr(t->right);
}

BinTree copy_trimmed(int h, BinTree t)
{
    return (!t || h<=0 ) ? NULL : newBinTree(t->element, copy_trimmed(h-1,t->left), copy_trimmed(h-1,t->right));
}

void modify_trimmed(int h, BinTree * t)
{
    if(!*t)
        return;
    if(h <= 0)
    {
        dealloca(*t);// procedura che dealloca l'albero
        *t = NULL;
    }
    else
    {
        modify_trimmed(h-1, &((*t)->left));
        modify_trimmed(h-1, &((*t)->right));
    }
}

void dealloca(BinTree t)
{
    if(t) {
        dealloca(t->left);
        dealloca(t->right);
        free(t);
    }
}


BinTree modify_bookTrimmed(int h, BinTree t)
{
    if(!t || h <= 0)
        return NULL;
    else
    {
        t->left = modify_bookTrimmed(h-1, t->left);
        t->right = modify_bookTrimmed(h-1, t->right);
        return t;
    }
}
