package cz.muni.fi.pa165.config;

import cz.muni.fi.pa165.PersistenceApplicationContext;
import cz.muni.fi.pa165.dto.*;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.*;

/**
 * @author opontes
 */
@Configuration
@Import(PersistenceApplicationContext.class)
@ComponentScan(basePackages = "cz.muni.fi.pa165")
public class ServiceConfig {

    @Bean
    public Mapper dozer(){
        DozerBeanMapper dozer = new DozerBeanMapper();
        dozer.addMapping(new DozerConfig());
        return dozer;
    }

    private class DozerConfig extends BeanMappingBuilder {
        @Override
        protected void configure() {
            mapping(Ghost.class, GhostDTO.class);
            mapping(Haunting.class, HauntingDTO.class);
            mapping(House.class, HouseDTO.class);
            mapping(Ability.class, AbilityDTO.class);
            mapping(Ability.class, AbilityCreateDTO.class);
            mapping(House.class, HouseCreateDTO.class);
            mapping(Haunting.class, HauntingCreateDTO.class);
            mapping(Ghost.class, GhostCreateDTO.class);

        }
    }

//    private class GhostConfig extends BeanMappingBuilder {
//        @Override
//        protected void configure() {
//            mapping(Ghost.class, GhostDTO.class);
//        }
//    }
//
//    private class HauntingConfig extends BeanMappingBuilder {
//        @Override
//        protected void configure() {
//            mapping(Haunting.class, HauntingDTO.class);
//        }
//    }
//
//    private class HouseConfig extends BeanMappingBuilder {
//        @Override
//        protected void configure() {
//            mapping(House.class, HouseDTO.class);
//        }
//    }
//
//    private class AbilityConfig extends BeanMappingBuilder {
//        @Override
//        protected void configure() {
//            mapping(Ability.class, AbilityDTO.class);
//        }
//    }
}
