package haja.Project.repository;

import haja.Project.domain.Task_Tag;
import haja.Project.domain.Tasknotice_Tag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Task_TagRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Task_Tag task_tag){
        em.persist(task_tag);
    }

    public Task_Tag findOne(Long id){
        return em.find(Task_Tag.class,id);
    }
    //여기에 findByTasknoticeId랑 findByTagId 메서드 추가

    public void delete(Task_Tag task_tag){
        em.remove(task_tag);
    }

    public List<Task_Tag> findByTaskId(Long id){
        return em.createQuery("select tt from Task_Tag tt where tt.task.id = :id", Task_Tag.class)
                .setParameter("id",id)
                .getResultList();
    }

    //저기 쿼리문에서 줄바꿀 때 공백(space) 줘야 에러 안나더라  //  tg " 마냥
    public List<Task_Tag> findByTagName(String name){
        return em.createQuery("select tt from Task_Tag tt join tt.task tk join tt.tag tg "
                        +"where tg.name Like :name and tt.tag.id = tg.id and tt.task.id = tk.id",Task_Tag.class)
                .setParameter("name","%"+name+"%")
                .getResultList();
    }

    public void deleteByTaskId(Long id) {
        em.createQuery("delete from Task_Tag t where t.task.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

}
