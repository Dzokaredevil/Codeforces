#include <iostream>
#include <cstdlib>

using namespace std;

class ListNode{

public :
    int value;
    ListNode *next;

};

void printList(ListNode *head){

    while(head){

        cout<<head->value<<" -> ";
        head = head->next;
    }
    cout<<endl;
}

ListNode* List1(){

    ListNode *head,*temp;

    head = new ListNode();
    temp = head ;

    for(int i=0;i<10;i++){

        head->value = i*i;
        head->next = new ListNode();
        head = head->next;
    }

    head->value =11*11;
    head->next = NULL;

    return temp;
}


ListNode* insertAtHead(ListNode* head, int value){

    ListNode* head1 = new ListNode();
    head1->value = value;
    head1->next = head;

    return head1;
}



ListNode* insertAtTail(ListNode* head, int value){

    ListNode* tail = new ListNode();
    tail->value = value;
    tail->next = NULL;

    ListNode* head1 = head;
    while(head->next){

        head = head->next;
    }

    head->next = tail;

    return head1;
}

ListNode* insertAfterIndex(int index, int value, ListNode* head){

    if(index == 0)
    return insertAtHead(head,value);

    ListNode* newNode = new ListNode(), *head1 = head;
    newNode->value = value;

    head = head->next;
    for(int i=1;i < index ; i++){
        head = head->next;
    }

    newNode->next = head->next;
    head->next = newNode;

    return head1;



}

ListNode* deleteNode(int value, ListNode* head){

    ListNode* head1 = head;
    if(head->value == value){

        ListNode* temp = head->next;
        free(head);
        return temp;
    }
    else {

        ListNode *prev = head;
        head = head->next;
        while(head->next){

            if(head->value == value){

                prev->next = head->next;
                free(head);
            }

            prev = head;
            head = head->next;

        }

        return head1;
    }
}

int listLength(ListNode* head){

    if(head->next == NULL)
        return 1;
    else
        return 1+listLength(head->next);
}

bool searchNode(ListNode* head, int value){

    if(head){

        if(head->value == value)
            return true;
        else
            return searchNode(head->next,value);
    }
    else
        return false;
}

ListNode* swapNodes(ListNode* head, int x,int y){

    ListNode* prevX,*currX;
    prevX = NULL;
    currX = head;

    ListNode* prevY, *currY;
    prevY = NULL;
    currY = head;

    while(currX){

        if(currX->value == x)
        break;

        prevX = currX;
        currX = currX->next;

    }

    while(currY){

        if(currY->value == y)
        break;

        prevY = currY;
        currY = currY->next;
    }

    if(!currX || !currY)
    return head;
    else
    {
        if(currX == head)
            head = currY;
        else
            prevX->next =currY;


        if(currY == head)
            head == currX;
        else
            prevY->next = currX;

        ListNode* temp = currY->next;
        currY->next =currX->next;
        currX->next = temp;

        return head;
    }

}

ListNode* deleteAlternateNodes(ListNode* head){

    ListNode* curr, *above, *temp, *head1;

    printList(head);

    curr = head->next;
    printList(head);
    head1=curr;
        printList(head);

    above = curr->next;
    printList(head);

    while(above){
        cout<<"Here "<<curr->value<<endl;
        curr->next = above->next;
        curr = curr->next;
        temp = above;
        free(temp);

        if(curr!= NULL)
            above = curr->next;
        else
            break;
    }

    return head1;
}

ListNode **alternateSplit(ListNode* head){

    ListNode* a[2];
    a[0] = head;
    a[1] = head->next;
    return a;

}

int main(){

    int prev_sum = 0, prev_length = 0, curr_sum = 0, curr_length = 0;
    int *a;
    int array_size;
    cin >> array_size;

    a = new int[array_size];
    for(int iter = 0; iter < array_size; iter++){
        cin >> a[iter];
    }

    curr_sum = a[0];
    curr_length = 1;
    for(int iter = 1; iter < array_size; iter++){
        if(a[iter] >= a[iter - 1]){
            curr_length++;
        } else {
            prev_length = max(curr_length, prev_length);
            curr_length = 1;
        }
    }

    cout << ((prev_length > curr_length) ? prev_length : curr_length);
	
    return 0;
}