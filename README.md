# workshop-java-01

## Circular buffer

### 1. Data structure ? (Internal)
+ Array of String

### 2. Operations/Behavior/Methods
+ writeData(string): boolean
+ readData(): string
+ isFull(): boolean
+ isEmpty(): boolean
+ setSize(int): void

### 3. Internal process
+ buffer size = 10 (default)
+ read pointer = 0
+ write pointer = 0

### 4.List of test cases
* TC01 => create_new_buffer_should_empty
* TC02 => create_new_buffer_with_default_size_should_10
* TC03 => write_A_B_to_buffer_should_read_A_B_from_buffer
* TC04 => read_data_in_full_buffer_should_make_it_not_full
* TC05 => write_and_read_should_make_buffer_empty
* TC06 => buffer_should_be_able_to_handle_more_than_10
* TC07 => buffer_that_become_full_again_should_return_full
* TC08 => insert_data_in_full_buffer_should_false
* TC09 => set_size_should_give_the_same_data
* TC10 => set_size_should_be_able_to_handle_more_data
* TC11 => read_when_empty_should_throw
* TC12 => init_buffer_with_different_size_should_be_empty
* TC13 => different_size_buffer_work_be_fillable


### 5.Refactor
* ตอนแปลงคะแนนเป็นคำให้เรียกใช้ function
* ใช้ else if และแก้ condition ให้เหตุการณ์ไม่เกี่ยวข้องกัน
* ยุบ case ที่ให้ result เหมือนกัน เป็น else