package Entity;


import org.springframework.data.jpa.repository.JpaRepository;

interface ProductsRepository extends JpaRepository<Products, Long> {

}