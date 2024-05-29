package ru.manannikov.learnMVC.scheduling;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleTaskStatusService {
    private final ScheduleTaskStatusRepository repository;

    // Транзакция :: Последовательность действий над данными, рассматриваемых с логической тз как одно целое (одна операция), т.е. если не удастся выполнить хотя бы один шаг, то вся операция с данными должна быть завершена неудачно.
    @Transactional
    public void saveUpdateStatus(boolean isSuccess) {

        ScheduleTaskStatusEntity newStatus = new ScheduleTaskStatusEntity();

        newStatus.setUpdateDateTime(LocalDateTime.now());
        newStatus.setSuccess(isSuccess);

        // При выполнении периодической задачи нужно так проверять что в таблице-журнале не более 10 записей. Старые записи удаляем.
        List<ScheduleTaskStatusEntity> records = repository.findAll();
        if (records.size() >= 10) {
            // Удаляем самую старую запись
            repository.delete(records.getFirst());
        }

        repository.save(newStatus);
    }

}
