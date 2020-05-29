class Node:

    def __init__(self, data, next_):
        self.data = data
        self.next = next_


class LinkedListItr:
    def __init__(self, head: Node):
        self.current = head

    def __next__(self):
        if self.current:
            data = self.current.data
            self.current = self.current.next
            return data
        else:
            raise StopIteration


class LinkedList:

    def __init__(self):
        self.head = None

    def add(self, data):
        self.head = Node(data, self.head)

    def __iter__(self):
        return LinkedListItr(self.head)

    @staticmethod
    def detect_loop(root: Node):
        slow_pointer = root
        fast_pointer = root
        while slow_pointer and fast_pointer and fast_pointer.next:
            slow_pointer = slow_pointer.next
            fast_pointer = fast_pointer.next.next
            if slow_pointer == fast_pointer:
                return True
        return False

    def reverse(self):
        self.head = self._reverse(self.head)

    @staticmethod
    def _reverse(root: Node):
        prev = None
        current = root
        while current:
            next_ = current.next
            current.next = prev
            prev = current
            current = next_

        return prev

# if __name__ == '__main__':
#     node5 = Node(5, None)
#     node4 = Node(4, node5)
#     node3 = Node(3, node4)
#     node2 = Node(2, node3)
#     node1 = Node(1, node2)
#     node5.next = node2
#
#     l_list = LinkedList()
#     print(l_list.detect_loop(node1))
