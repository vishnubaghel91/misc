from src.ds.linkedlist.ps_linked_list import LinkedList


def test_reverse():
    l_list = LinkedList()
    l_list.add(1)
    l_list.add(2)
    l_list.add(3)
    l_list.add(4)
    l_list.reverse()

    l_iter = iter(l_list)
    assert next(l_iter) == 1
