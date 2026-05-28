def solution(phone_book):
    phone_book.sort()
    
    for idx, phone in enumerate(phone_book):
        if idx!=len(phone_book)-1 and phone in phone_book[idx+1] and phone == phone_book[idx+1][:len(phone)]:
            return False
        
    return True