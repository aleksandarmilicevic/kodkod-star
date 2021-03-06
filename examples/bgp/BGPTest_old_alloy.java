package bgp;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import kodkod.ast.*;
import kodkod.ast.operator.*;
import kodkod.instance.*;
import kodkod.util.nodes.PrettyPrinter;
import kodkod.engine.*;
import kodkod.engine.satlab.SATFactory;
import kodkod.engine.config.Options;
import korat.utils.io.IOUtils;

public final class BGPTest_old_alloy {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Natural");
        Relation x7 = Relation.unary("ord/Ord");
        Relation x8 = Relation.unary("this/Zero");
        Relation x9 = Relation.unary("this/One");
        Relation x10 = Relation.nary("this/Natural.data", 4);
        Relation x11 = Relation.unary("ord/Ord.First");
        Relation x12 = Relation.nary("ord/Ord.Next", 2);
        Relation x13 = Relation.unary("");

        List<String> atomlist = Arrays.asList("-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "0",
                "1", "2", "3", "4", "5", "6", "7", "Natural$0", "Natural$1", "Natural$2",
                "Natural$3", "ord/Ord$0");

        Universe universe = new Universe(atomlist);
        TupleFactory factory = universe.factory();
        Bounds bounds = new Bounds(universe);

        TupleSet x0_upper = factory.noneOf(1);
        x0_upper.add(factory.tuple("-8"));
        bounds.boundExactly(x0, x0_upper);

        TupleSet x1_upper = factory.noneOf(1);
        x1_upper.add(factory.tuple("0"));
        bounds.boundExactly(x1, x1_upper);

        TupleSet x2_upper = factory.noneOf(1);
        x2_upper.add(factory.tuple("7"));
        bounds.boundExactly(x2, x2_upper);

        TupleSet x3_upper = factory.noneOf(2);
        x3_upper.add(factory.tuple("-8").product(factory.tuple("-7")));
        x3_upper.add(factory.tuple("-7").product(factory.tuple("-6")));
        x3_upper.add(factory.tuple("-6").product(factory.tuple("-5")));
        x3_upper.add(factory.tuple("-5").product(factory.tuple("-4")));
        x3_upper.add(factory.tuple("-4").product(factory.tuple("-3")));
        x3_upper.add(factory.tuple("-3").product(factory.tuple("-2")));
        x3_upper.add(factory.tuple("-2").product(factory.tuple("-1")));
        x3_upper.add(factory.tuple("-1").product(factory.tuple("0")));
        x3_upper.add(factory.tuple("0").product(factory.tuple("1")));
        x3_upper.add(factory.tuple("1").product(factory.tuple("2")));
        x3_upper.add(factory.tuple("2").product(factory.tuple("3")));
        x3_upper.add(factory.tuple("3").product(factory.tuple("4")));
        x3_upper.add(factory.tuple("4").product(factory.tuple("5")));
        x3_upper.add(factory.tuple("5").product(factory.tuple("6")));
        x3_upper.add(factory.tuple("6").product(factory.tuple("7")));
        bounds.boundExactly(x3, x3_upper);

        TupleSet x4_upper = factory.noneOf(1);
        x4_upper.add(factory.tuple("0"));
        x4_upper.add(factory.tuple("1"));
        x4_upper.add(factory.tuple("2"));
        x4_upper.add(factory.tuple("3"));
        bounds.boundExactly(x4, x4_upper);

        TupleSet x5_upper = factory.noneOf(1);
        bounds.boundExactly(x5, x5_upper);

        TupleSet x6_upper = factory.noneOf(1);
        x6_upper.add(factory.tuple("Natural$0"));
        x6_upper.add(factory.tuple("Natural$1"));
        x6_upper.add(factory.tuple("Natural$2"));
        x6_upper.add(factory.tuple("Natural$3"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("ord/Ord$0"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Natural$0"));
        x8_upper.add(factory.tuple("Natural$1"));
        x8_upper.add(factory.tuple("Natural$2"));
        x8_upper.add(factory.tuple("Natural$3"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Natural$0"));
        x9_upper.add(factory.tuple("Natural$1"));
        x9_upper.add(factory.tuple("Natural$2"));
        x9_upper.add(factory.tuple("Natural$3"));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(4);
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$0")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$1")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$2")).product(factory.tuple("Natural$3")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$0")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$1")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$2")));
        x10_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")).product(
                factory.tuple("Natural$3")).product(factory.tuple("Natural$3")));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(1);
        x11_upper.add(factory.tuple("Natural$0"));
        x11_upper.add(factory.tuple("Natural$1"));
        x11_upper.add(factory.tuple("Natural$2"));
        x11_upper.add(factory.tuple("Natural$3"));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(2);
        x12_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")));
        x12_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")));
        x12_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")));
        x12_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")));
        x12_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")));
        x12_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")));
        x12_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")));
        x12_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")));
        x12_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")));
        x12_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")));
        x12_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")));
        x12_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")));
        x12_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")));
        x12_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")));
        x12_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")));
        x12_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(1);
        x13_upper.add(factory.tuple("Natural$0"));
        x13_upper.add(factory.tuple("Natural$1"));
        x13_upper.add(factory.tuple("Natural$2"));
        x13_upper.add(factory.tuple("Natural$3"));
        bounds.bound(x13, x13_upper);

        bounds.boundExactly(-8, factory.range(factory.tuple("-8"), factory.tuple("-8")));
        bounds.boundExactly(-7, factory.range(factory.tuple("-7"), factory.tuple("-7")));
        bounds.boundExactly(-6, factory.range(factory.tuple("-6"), factory.tuple("-6")));
        bounds.boundExactly(-5, factory.range(factory.tuple("-5"), factory.tuple("-5")));
        bounds.boundExactly(-4, factory.range(factory.tuple("-4"), factory.tuple("-4")));
        bounds.boundExactly(-3, factory.range(factory.tuple("-3"), factory.tuple("-3")));
        bounds.boundExactly(-2, factory.range(factory.tuple("-2"), factory.tuple("-2")));
        bounds.boundExactly(-1, factory.range(factory.tuple("-1"), factory.tuple("-1")));
        bounds.boundExactly(0, factory.range(factory.tuple("0"), factory.tuple("0")));
        bounds.boundExactly(1, factory.range(factory.tuple("1"), factory.tuple("1")));
        bounds.boundExactly(2, factory.range(factory.tuple("2"), factory.tuple("2")));
        bounds.boundExactly(3, factory.range(factory.tuple("3"), factory.tuple("3")));
        bounds.boundExactly(4, factory.range(factory.tuple("4"), factory.tuple("4")));
        bounds.boundExactly(5, factory.range(factory.tuple("5"), factory.tuple("5")));
        bounds.boundExactly(6, factory.range(factory.tuple("6"), factory.tuple("6")));
        bounds.boundExactly(7, factory.range(factory.tuple("7"), factory.tuple("7")));

        Formula x15 = x8.in(x6);
        Formula x16 = x9.in(x6);
        Formula x17 = x8.one();
        Formula x18 = x9.lone();
        Variable x21 = Variable.unary("checkOneSolvable3ToNinjaWheel_this");
        Decls x20 = x21.oneOf(x6);
        Expression x23 = x21.join(x10);
        Expression x25 = x6.product(x6);
        Expression x24 = x6.product(x25);
        Formula x22 = x23.in(x24);
        Formula x19 = x22.forAll(x20);
        Expression x29 = x10.join(Expression.UNIV);
        Expression x28 = x29.join(Expression.UNIV);
        Expression x27 = x28.join(Expression.UNIV);
        Formula x26 = x27.in(x6);
        Expression x33 = x7.product(x11);
        Expression x32 = x7.join(x33);
        Formula x31 = x32.in(x6);
        Expression x36 = x7.product(x12);
        Expression x35 = x7.join(x36);
        Expression x37 = x6.product(x6);
        Formula x34 = x35.in(x37);
        Formula x38 = x12.totalOrder(x6, x11, x13);
        Formula x39 = x11.in(x8);
        Expression x41 = x11.join(x12);
        Formula x40 = x41.in(x9);
        Expression x46 = x10.join(x6);
        Expression x45 = x46.join(x6);
        Expression x44 = x45.join(x6);
        Expression x47 = x44.join(x12);
        Expression x43 = x44.difference(x47);
        Formula x42 = x43.in(x11);
        Variable x50 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
        Decls x49 = x50.oneOf(x6);
        Expression x55 = x50.join(x10);
        Expression x54 = x55.join(x6);
        Expression x53 = x54.join(x6);
        Expression x56 = x53.join(x12);
        Expression x52 = x53.difference(x56);
        Formula x51 = x52.in(x11);
        Formula x48 = x51.forAll(x49);
        Variable x59 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
        Decls x58 = x59.oneOf(x6);
        Variable x62 = Variable.unary("checkOneSolvable3ToNinjaWheel_pathPref");
        Decls x61 = x62.oneOf(x6);
        Expression x67 = x59.join(x10);
        Expression x66 = x62.join(x67);
        Expression x65 = x66.join(x6);
        Expression x68 = x65.join(x12);
        Expression x64 = x65.difference(x68);
        Formula x63 = x64.in(x11);
        Formula x60 = x63.forAll(x61);
        Formula x57 = x60.forAll(x58);
        Variable x71 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
        Decls x70 = x71.oneOf(x6);
        Variable x74 = Variable.unary("checkOneSolvable3ToNinjaWheel_pathPref");
        Decls x73 = x74.oneOf(x6);
        Variable x77 = Variable.unary("checkOneSolvable3ToNinjaWheel_pathIndex");
        Decls x76 = x77.oneOf(x6);
        Expression x81 = x71.join(x10);
        Expression x80 = x74.join(x81);
        Expression x79 = x77.join(x80);
        Formula x78 = x79.lone();
        Formula x75 = x78.forAll(x76);
        Formula x72 = x75.forAll(x73);
        Formula x69 = x72.forAll(x70);
        Variable x84 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
        Decls x83 = x84.oneOf(x44);
        Expression x86 = x84.join(x10);
        Formula x85 = x86.some();
        Formula x82 = x85.forAll(x83);
        Variable x89 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
        Decls x88 = x89.oneOf(x44);
        Variable x92 = Variable.unary("checkOneSolvable3ToNinjaWheel_pathPref");
        Expression x95 = x89.join(x10);
        Expression x94 = x95.join(x6);
        Expression x93 = x94.join(x6);
        Decls x91 = x92.oneOf(x93);
        Expression x101 = x89.join(x10);
        Expression x100 = x92.join(x101);
        Expression x99 = x6.join(x100);
        Formula x98 = x99.in(x44);
        Expression x104 = x100.join(x6);
        IntExpression x103 = x104.count();
        Expression x106 = x6.join(x100);
        IntExpression x105 = x106.count();
        Formula x102 = x103.eq(x105);
        Formula x97 = x98.and(x102);
        Expression x108 = x8.join(x100);
        Formula x107 = x108.eq(x89);
        Formula x96 = x97.and(x107);
        Formula x90 = x96.forAll(x91);
        Formula x87 = x90.forAll(x88);
        Variable x111 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
        Decls x110 = x111.oneOf(x44);
        Variable x115 = Variable.unary("checkOneSolvable3ToNinjaWheel_i");
        Expression x118 = x111.join(x10);
        Expression x117 = x118.join(x6);
        Expression x116 = x117.join(x6);
        Decls x114 = x115.oneOf(x116);
        Variable x120 = Variable.unary("checkOneSolvable3ToNinjaWheel_j");
        Decls x119 = x120.oneOf(x116);
        Decls x113 = x114.and(x119);
        Expression x124 = x115.intersection(x120);
        Formula x123 = x124.no();
        Expression x127 = x111.join(x10);
        Expression x126 = x115.join(x127);
        Expression x129 = x111.join(x10);
        Expression x128 = x120.join(x129);
        Formula x125 = x126.eq(x128);
        Formula x122 = x123.and(x125);
        Formula x121 = x122.not();
        Formula x112 = x121.forAll(x113);
        Formula x109 = x112.forAll(x110);
        Expression x134 = x6.join(x10);
        Expression x133 = x134.join(x6);
        Expression x132 = x133.join(x6);
        IntExpression x131 = x132.count();
        IntExpression x135 = x6.count();
        Formula x130 = x131.lt(x135);
        IntExpression x140 = x44.count();
        IntExpression x141 = IntConstant.constant(3);
        Formula x139 = x140.eq(x141);
        Formula x138 = x139.not();
        Variable x147 = Variable.unary("oneSolvableFun3_i1");
        Decls x146 = x147.oneOf(x6);
        Variable x149 = Variable.unary("oneSolvableFun3_i2");
        Decls x148 = x149.oneOf(x6);
        Variable x151 = Variable.unary("oneSolvableFun3_i3");
        Decls x150 = x151.oneOf(x6);
        Decls x145 = x146.and(x148).and(x150);
        Expression x158 = x8.join(x10);
        Expression x157 = x158.join(x6);
        Expression x156 = x157.join(x6);
        Expression x163 = x8.join(x10);
        Expression x162 = x163.join(x6);
        Expression x161 = x162.join(x6);
        Expression x166 = x12.transpose();
        Expression x165 = x166.closure();
        Expression x164 = x161.join(x165);
        Expression x160 = x161.difference(x164);
        Expression x159 = x160.join(x12);
        Expression x155 = x156.union(x159);
        Formula x154 = x147.in(x155);
        Expression x172 = x9.join(x10);
        Expression x171 = x172.join(x6);
        Expression x170 = x171.join(x6);
        Expression x177 = x9.join(x10);
        Expression x176 = x177.join(x6);
        Expression x175 = x176.join(x6);
        Expression x180 = x12.transpose();
        Expression x179 = x180.closure();
        Expression x178 = x175.join(x179);
        Expression x174 = x175.difference(x178);
        Expression x173 = x174.join(x12);
        Expression x169 = x170.union(x173);
        Formula x168 = x149.in(x169);
        Expression x184 = x8.product(x147);
        Expression x185 = x9.product(x149);
        Expression x183 = x184.union(x185);
        Expression x187 = x9.join(x12);
        Expression x186 = x187.product(x151);
        Expression x182 = x183.union(x186);
        Variable x191 = Variable.unary("ValidBest_node");
        Decls x190 = x191.oneOf(x6);
        Variable x193 = Variable.unary("ValidBest_pref");
        Decls x192 = x193.oneOf(x6);
        Decls x189 = x190.and(x192);
        Variable x200 = Variable.unary("ValidChoices_n");
        Decls x199 = x200.oneOf(x6);
        Variable x202 = Variable.unary("ValidChoices_p");
        Decls x201 = x202.oneOf(x6);
        Decls x198 = x199.and(x201);
        Expression x208 = x200.join(x10);
        Expression x207 = x208.join(x6);
        Expression x206 = x207.join(x6);
        Expression x213 = x200.join(x10);
        Expression x212 = x213.join(x6);
        Expression x211 = x212.join(x6);
        Expression x216 = x12.transpose();
        Expression x215 = x216.closure();
        Expression x214 = x211.join(x215);
        Expression x210 = x211.difference(x214);
        Expression x209 = x210.join(x12);
        Expression x205 = x206.union(x209);
        Formula x204 = x202.in(x205);
        Expression x222 = x200.join(x10);
        Expression x221 = x222.join(x6);
        Expression x220 = x221.join(x6);
        Formula x219 = x202.in(x220);
        Formula x218 = x219.not();
        Expression x228 = x200.join(x10);
        Expression x227 = x202.join(x228);
        Expression x226 = x9.join(x227);
        Formula x225 = x226.some();
        Formula x224 = x225.not();
        Expression x235 = x200.join(x10);
        Expression x234 = x235.join(x6);
        Expression x233 = x234.join(x6);
        Formula x232 = x202.in(x233);
        Formula x231 = x232.not();
        Formula x230 = x231.not();
        Expression x239 = x200.join(x10);
        Expression x238 = x202.join(x239);
        Expression x237 = x12.join(x238);
        Expression x241 = x226.join(x182);
        Expression x242 = x226.join(x10);
        Expression x240 = x241.join(x242);
        Formula x236 = x237.eq(x240);
        Formula x229 = x230.and(x236);
        Formula x223 = x224.or(x229);
        Formula x217 = x218.or(x223);
        Formula x203 = x204.and(x217);
        Expression x197 = x203.comprehension(x198);
        Expression x196 = x191.join(x197);
        Formula x195 = x193.in(x196);
        Variable x245 = Variable.unary("ValidBest_j");
        Expression x246 = x191.join(x197);
        Decls x244 = x245.oneOf(x246);
        Expression x251 = x12.transpose();
        Expression x250 = x251.closure();
        Expression x249 = x193.join(x250);
        Formula x248 = x245.in(x249);
        Formula x247 = x248.not();
        Formula x243 = x247.forAll(x244);
        Formula x194 = x195.and(x243);
        Expression x188 = x194.comprehension(x189);
        Formula x181 = x182.eq(x188);
        Formula x167 = x168.and(x181);
        Formula x153 = x154.and(x167);
        Expression x256 = x187.join(x10);
        Expression x255 = x256.join(x6);
        Expression x254 = x255.join(x6);
        Expression x261 = x187.join(x10);
        Expression x260 = x261.join(x6);
        Expression x259 = x260.join(x6);
        Expression x264 = x12.transpose();
        Expression x263 = x264.closure();
        Expression x262 = x259.join(x263);
        Expression x258 = x259.difference(x262);
        Expression x257 = x258.join(x12);
        Expression x253 = x254.union(x257);
        Formula x252 = x151.in(x253);
        Formula x152 = x153.and(x252);
        Expression x144 = x152.comprehension(x145);
        Formula x143 = x144.one();
        Variable x270 = Variable.unary("DW3NE_p1");
        Expression x274 = x8.join(x10);
        Expression x273 = x274.join(x6);
        Expression x272 = x273.join(x6);
        Expression x279 = x8.join(x10);
        Expression x278 = x279.join(x6);
        Expression x277 = x278.join(x6);
        Expression x282 = x12.transpose();
        Expression x281 = x282.closure();
        Expression x280 = x277.join(x281);
        Expression x276 = x277.difference(x280);
        Expression x275 = x276.join(x12);
        Expression x271 = x272.union(x275);
        Decls x269 = x270.oneOf(x271);
        Variable x284 = Variable.unary("DW3NE_p2");
        Expression x288 = x9.join(x10);
        Expression x287 = x288.join(x6);
        Expression x286 = x287.join(x6);
        Expression x293 = x9.join(x10);
        Expression x292 = x293.join(x6);
        Expression x291 = x292.join(x6);
        Expression x296 = x12.transpose();
        Expression x295 = x296.closure();
        Expression x294 = x291.join(x295);
        Expression x290 = x291.difference(x294);
        Expression x289 = x290.join(x12);
        Expression x285 = x286.union(x289);
        Decls x283 = x284.oneOf(x285);
        Variable x298 = Variable.unary("DW3NE_p3");
        Expression x303 = x9.join(x12);
        Expression x302 = x303.join(x10);
        Expression x301 = x302.join(x6);
        Expression x300 = x301.join(x6);
        Expression x308 = x303.join(x10);
        Expression x307 = x308.join(x6);
        Expression x306 = x307.join(x6);
        Expression x311 = x12.transpose();
        Expression x310 = x311.closure();
        Expression x309 = x306.join(x310);
        Expression x305 = x306.difference(x309);
        Expression x304 = x305.join(x12);
        Expression x299 = x300.union(x304);
        Decls x297 = x298.oneOf(x299);
        Decls x268 = x269.and(x283).and(x297);
        Variable x314 = Variable.unary("DW3NE_p1h");
        Variable x317 = Variable.unary("DW3NE_i");
        Decls x316 = x317.oneOf(x6);
        Expression x321 = x12.transpose();
        Expression x320 = x321.closure();
        Expression x319 = x270.join(x320);
        Formula x318 = x317.in(x319);
        Expression x315 = x318.comprehension(x316);
        Decls x313 = x314.oneOf(x315);
        Variable x324 = Variable.unary("DW3NE_p2h");
        Variable x327 = Variable.unary("DW3NE_i");
        Decls x326 = x327.oneOf(x6);
        Expression x331 = x12.transpose();
        Expression x330 = x331.closure();
        Expression x329 = x284.join(x330);
        Formula x328 = x327.in(x329);
        Expression x325 = x328.comprehension(x326);
        Decls x323 = x324.oneOf(x325);
        Variable x334 = Variable.unary("DW3NE_p3h");
        Variable x337 = Variable.unary("DW3NE_i");
        Decls x336 = x337.oneOf(x6);
        Expression x341 = x12.transpose();
        Expression x340 = x341.closure();
        Expression x339 = x298.join(x340);
        Formula x338 = x337.in(x339);
        Expression x335 = x338.comprehension(x336);
        Decls x333 = x334.oneOf(x335);
        Variable x345 = Variable.unary("DW3NE_pa2h");
        Expression x347 = x9.union(x8);
        Expression x348 = x9.join(x12);
        Expression x346 = x347.union(x348);
        Decls x344 = x345.oneOf(x346);
        Variable x350 = Variable.unary("DW3NE_pa3h");
        Decls x349 = x350.oneOf(x346);
        Decls x343 = x344.and(x349);
        Variable x353 = Variable.unary("DW3NE_pa2l");
        Expression x356 = x9.union(x8);
        Expression x357 = x9.join(x12);
        Expression x355 = x356.union(x357);
        Expression x354 = x355.difference(x345);
        Decls x352 = x353.oneOf(x354);
        Variable x360 = Variable.unary("DW3NE_pa3l");
        Expression x363 = x9.union(x8);
        Expression x364 = x9.join(x12);
        Expression x362 = x363.union(x364);
        Expression x361 = x362.difference(x350);
        Decls x359 = x360.oneOf(x361);
        Variable x371 = Variable.unary("goesThruItsOwnParity_pref2");
        Expression x377 = x8.join(x10);
        Expression x376 = x314.join(x377);
        Expression x375 = x9.join(x376);
        Expression x374 = x375.join(x10);
        Expression x373 = x374.join(x6);
        Expression x372 = x373.join(x6);
        Decls x370 = x371.oneOf(x372);
        Expression x382 = x8.join(x10);
        Expression x381 = x314.join(x382);
        Expression x380 = x12.join(x381);
        Expression x384 = x375.join(x10);
        Expression x383 = x371.join(x384);
        Formula x379 = x380.eq(x383);
        Expression x394 = x270.product(x9);
        Expression x393 = x8.product(x394);
        Expression x396 = x314.product(x8);
        Expression x395 = x8.product(x396);
        Expression x392 = x393.union(x395);
        Expression x398 = x284.product(x353);
        Expression x397 = x9.product(x398);
        Expression x391 = x392.union(x397);
        Expression x400 = x324.product(x345);
        Expression x399 = x9.product(x400);
        Expression x390 = x391.union(x399);
        Expression x402 = x298.product(x360);
        Expression x401 = x303.product(x402);
        Expression x389 = x390.union(x401);
        Expression x404 = x334.product(x350);
        Expression x403 = x303.product(x404);
        Expression x388 = x389.union(x403);
        Expression x387 = x8.join(x388);
        Expression x386 = x314.join(x387);
        Expression x406 = x375.join(x388);
        Expression x405 = x371.join(x406);
        Formula x385 = x386.eq(x405);
        Formula x378 = x379.and(x385);
        Formula x369 = x378.forSome(x370);
        Expression x413 = x8.join(x10);
        Expression x412 = x413.join(x6);
        Expression x411 = x412.join(x6);
        Formula x410 = x270.in(x411);
        Formula x409 = x410.not();
        Expression x417 = x8.join(x10);
        Expression x416 = x270.join(x417);
        Expression x415 = x9.join(x416);
        Formula x414 = x415.no();
        Formula x408 = x409.or(x414);
        Variable x420 = Variable.unary("goesThruItsOwnParity_pref2");
        Expression x426 = x8.join(x10);
        Expression x425 = x270.join(x426);
        Expression x424 = x9.join(x425);
        Expression x423 = x424.join(x10);
        Expression x422 = x423.join(x6);
        Expression x421 = x422.join(x6);
        Decls x419 = x420.oneOf(x421);
        Expression x431 = x8.join(x10);
        Expression x430 = x270.join(x431);
        Expression x429 = x12.join(x430);
        Expression x433 = x424.join(x10);
        Expression x432 = x420.join(x433);
        Formula x428 = x429.eq(x432);
        Expression x436 = x8.join(x388);
        Expression x435 = x270.join(x436);
        Expression x438 = x424.join(x388);
        Expression x437 = x420.join(x438);
        Formula x434 = x435.eq(x437);
        Formula x427 = x428.and(x434);
        Formula x418 = x427.forSome(x419);
        Formula x407 = x408.or(x418);
        Formula x368 = x369.and(x407);
        Variable x441 = Variable.unary("DWNodeCheckNE_k");
        Variable x444 = Variable.unary("DWNodeCheckNE_i");
        Decls x443 = x444.oneOf(x6);
        Expression x449 = x12.transpose();
        Expression x448 = x449.closure();
        Expression x447 = x270.join(x448);
        Formula x446 = x444.in(x447);
        Formula x451 = x444.eq(x314);
        Formula x450 = x451.not();
        Formula x445 = x446.and(x450);
        Expression x442 = x445.comprehension(x443);
        Decls x440 = x441.oneOf(x442);
        Expression x457 = x8.join(x10);
        Expression x456 = x441.join(x457);
        Expression x455 = x9.join(x456);
        Formula x454 = x455.no();
        Formula x453 = x454.not();
        Variable x460 = Variable.unary("DWNodeCheckNE_first_hop_k_pref");
        Expression x464 = x8.join(x10);
        Expression x463 = x441.join(x464);
        Expression x462 = x9.join(x463);
        Expression x470 = x8.product(x270);
        Expression x471 = x8.product(x314);
        Expression x469 = x470.union(x471);
        Expression x472 = x9.product(x284);
        Expression x468 = x469.union(x472);
        Expression x473 = x9.product(x324);
        Expression x467 = x468.union(x473);
        Expression x474 = x303.product(x298);
        Expression x466 = x467.union(x474);
        Expression x475 = x303.product(x334);
        Expression x465 = x466.union(x475);
        Expression x461 = x462.join(x465);
        Decls x459 = x460.oneOf(x461);
        Expression x484 = x8.join(x10);
        Expression x483 = x484.join(x6);
        Expression x482 = x483.join(x6);
        Formula x481 = x441.in(x482);
        Formula x480 = x481.not();
        Formula x479 = x480.not();
        Expression x488 = x8.join(x10);
        Expression x487 = x441.join(x488);
        Expression x486 = x12.join(x487);
        Expression x490 = x462.join(x10);
        Expression x489 = x460.join(x490);
        Formula x485 = x486.eq(x489);
        Formula x478 = x479.and(x485);
        Formula x477 = x478.not();
        Expression x494 = x462.join(x388);
        Expression x493 = x460.join(x494);
        Expression x496 = x8.join(x388);
        Expression x495 = x314.join(x496);
        Formula x492 = x493.eq(x495);
        Expression x499 = x12.closure();
        Expression x498 = x314.join(x499);
        Formula x497 = x441.in(x498);
        Formula x491 = x492.and(x497);
        Formula x476 = x477.or(x491);
        Formula x458 = x476.forAll(x459);
        Formula x452 = x453.and(x458);
        Formula x439 = x452.forAll(x440);
        Formula x367 = x368.and(x439);
        Variable x504 = Variable.unary("goesThruItsOwnParity_pref2");
        Expression x510 = x9.join(x10);
        Expression x509 = x324.join(x510);
        Expression x508 = x9.join(x509);
        Expression x507 = x508.join(x10);
        Expression x506 = x507.join(x6);
        Expression x505 = x506.join(x6);
        Decls x503 = x504.oneOf(x505);
        Expression x515 = x9.join(x10);
        Expression x514 = x324.join(x515);
        Expression x513 = x12.join(x514);
        Expression x517 = x508.join(x10);
        Expression x516 = x504.join(x517);
        Formula x512 = x513.eq(x516);
        Expression x520 = x9.join(x388);
        Expression x519 = x324.join(x520);
        Expression x522 = x508.join(x388);
        Expression x521 = x504.join(x522);
        Formula x518 = x519.eq(x521);
        Formula x511 = x512.and(x518);
        Formula x502 = x511.forSome(x503);
        Expression x529 = x9.join(x10);
        Expression x528 = x529.join(x6);
        Expression x527 = x528.join(x6);
        Formula x526 = x284.in(x527);
        Formula x525 = x526.not();
        Expression x533 = x9.join(x10);
        Expression x532 = x284.join(x533);
        Expression x531 = x9.join(x532);
        Formula x530 = x531.no();
        Formula x524 = x525.or(x530);
        Variable x536 = Variable.unary("goesThruItsOwnParity_pref2");
        Expression x542 = x9.join(x10);
        Expression x541 = x284.join(x542);
        Expression x540 = x9.join(x541);
        Expression x539 = x540.join(x10);
        Expression x538 = x539.join(x6);
        Expression x537 = x538.join(x6);
        Decls x535 = x536.oneOf(x537);
        Expression x547 = x9.join(x10);
        Expression x546 = x284.join(x547);
        Expression x545 = x12.join(x546);
        Expression x549 = x540.join(x10);
        Expression x548 = x536.join(x549);
        Formula x544 = x545.eq(x548);
        Expression x552 = x9.join(x388);
        Expression x551 = x284.join(x552);
        Expression x554 = x540.join(x388);
        Expression x553 = x536.join(x554);
        Formula x550 = x551.eq(x553);
        Formula x543 = x544.and(x550);
        Formula x534 = x543.forSome(x535);
        Formula x523 = x524.or(x534);
        Formula x501 = x502.and(x523);
        Variable x557 = Variable.unary("DWNodeCheckNE_k");
        Variable x560 = Variable.unary("DWNodeCheckNE_i");
        Decls x559 = x560.oneOf(x6);
        Expression x565 = x12.transpose();
        Expression x564 = x565.closure();
        Expression x563 = x284.join(x564);
        Formula x562 = x560.in(x563);
        Formula x567 = x560.eq(x324);
        Formula x566 = x567.not();
        Formula x561 = x562.and(x566);
        Expression x558 = x561.comprehension(x559);
        Decls x556 = x557.oneOf(x558);
        Expression x573 = x9.join(x10);
        Expression x572 = x557.join(x573);
        Expression x571 = x9.join(x572);
        Formula x570 = x571.no();
        Formula x569 = x570.not();
        Variable x576 = Variable.unary("DWNodeCheckNE_first_hop_k_pref");
        Expression x580 = x9.join(x10);
        Expression x579 = x557.join(x580);
        Expression x578 = x9.join(x579);
        Expression x577 = x578.join(x465);
        Decls x575 = x576.oneOf(x577);
        Expression x589 = x9.join(x10);
        Expression x588 = x589.join(x6);
        Expression x587 = x588.join(x6);
        Formula x586 = x557.in(x587);
        Formula x585 = x586.not();
        Formula x584 = x585.not();
        Expression x593 = x9.join(x10);
        Expression x592 = x557.join(x593);
        Expression x591 = x12.join(x592);
        Expression x595 = x578.join(x10);
        Expression x594 = x576.join(x595);
        Formula x590 = x591.eq(x594);
        Formula x583 = x584.and(x590);
        Formula x582 = x583.not();
        Expression x599 = x578.join(x388);
        Expression x598 = x576.join(x599);
        Expression x601 = x9.join(x388);
        Expression x600 = x324.join(x601);
        Formula x597 = x598.eq(x600);
        Expression x604 = x12.closure();
        Expression x603 = x324.join(x604);
        Formula x602 = x557.in(x603);
        Formula x596 = x597.and(x602);
        Formula x581 = x582.or(x596);
        Formula x574 = x581.forAll(x575);
        Formula x568 = x569.and(x574);
        Formula x555 = x568.forAll(x556);
        Formula x500 = x501.and(x555);
        Formula x366 = x367.and(x500);
        Variable x609 = Variable.unary("goesThruItsOwnParity_pref2");
        Expression x615 = x303.join(x10);
        Expression x614 = x334.join(x615);
        Expression x613 = x9.join(x614);
        Expression x612 = x613.join(x10);
        Expression x611 = x612.join(x6);
        Expression x610 = x611.join(x6);
        Decls x608 = x609.oneOf(x610);
        Expression x620 = x303.join(x10);
        Expression x619 = x334.join(x620);
        Expression x618 = x12.join(x619);
        Expression x622 = x613.join(x10);
        Expression x621 = x609.join(x622);
        Formula x617 = x618.eq(x621);
        Expression x625 = x303.join(x388);
        Expression x624 = x334.join(x625);
        Expression x627 = x613.join(x388);
        Expression x626 = x609.join(x627);
        Formula x623 = x624.eq(x626);
        Formula x616 = x617.and(x623);
        Formula x607 = x616.forSome(x608);
        Expression x634 = x303.join(x10);
        Expression x633 = x634.join(x6);
        Expression x632 = x633.join(x6);
        Formula x631 = x298.in(x632);
        Formula x630 = x631.not();
        Expression x638 = x303.join(x10);
        Expression x637 = x298.join(x638);
        Expression x636 = x9.join(x637);
        Formula x635 = x636.no();
        Formula x629 = x630.or(x635);
        Variable x641 = Variable.unary("goesThruItsOwnParity_pref2");
        Expression x647 = x303.join(x10);
        Expression x646 = x298.join(x647);
        Expression x645 = x9.join(x646);
        Expression x644 = x645.join(x10);
        Expression x643 = x644.join(x6);
        Expression x642 = x643.join(x6);
        Decls x640 = x641.oneOf(x642);
        Expression x652 = x303.join(x10);
        Expression x651 = x298.join(x652);
        Expression x650 = x12.join(x651);
        Expression x654 = x645.join(x10);
        Expression x653 = x641.join(x654);
        Formula x649 = x650.eq(x653);
        Expression x657 = x303.join(x388);
        Expression x656 = x298.join(x657);
        Expression x659 = x645.join(x388);
        Expression x658 = x641.join(x659);
        Formula x655 = x656.eq(x658);
        Formula x648 = x649.and(x655);
        Formula x639 = x648.forSome(x640);
        Formula x628 = x629.or(x639);
        Formula x606 = x607.and(x628);
        Variable x662 = Variable.unary("DWNodeCheckNE_k");
        Variable x665 = Variable.unary("DWNodeCheckNE_i");
        Decls x664 = x665.oneOf(x6);
        Expression x670 = x12.transpose();
        Expression x669 = x670.closure();
        Expression x668 = x298.join(x669);
        Formula x667 = x665.in(x668);
        Formula x672 = x665.eq(x334);
        Formula x671 = x672.not();
        Formula x666 = x667.and(x671);
        Expression x663 = x666.comprehension(x664);
        Decls x661 = x662.oneOf(x663);
        Expression x678 = x303.join(x10);
        Expression x677 = x662.join(x678);
        Expression x676 = x9.join(x677);
        Formula x675 = x676.no();
        Formula x674 = x675.not();
        Variable x681 = Variable.unary("DWNodeCheckNE_first_hop_k_pref");
        Expression x685 = x303.join(x10);
        Expression x684 = x662.join(x685);
        Expression x683 = x9.join(x684);
        Expression x682 = x683.join(x465);
        Decls x680 = x681.oneOf(x682);
        Expression x694 = x303.join(x10);
        Expression x693 = x694.join(x6);
        Expression x692 = x693.join(x6);
        Formula x691 = x662.in(x692);
        Formula x690 = x691.not();
        Formula x689 = x690.not();
        Expression x698 = x303.join(x10);
        Expression x697 = x662.join(x698);
        Expression x696 = x12.join(x697);
        Expression x700 = x683.join(x10);
        Expression x699 = x681.join(x700);
        Formula x695 = x696.eq(x699);
        Formula x688 = x689.and(x695);
        Formula x687 = x688.not();
        Expression x704 = x683.join(x388);
        Expression x703 = x681.join(x704);
        Expression x706 = x303.join(x388);
        Expression x705 = x334.join(x706);
        Formula x702 = x703.eq(x705);
        Expression x709 = x12.closure();
        Expression x708 = x334.join(x709);
        Formula x707 = x662.in(x708);
        Formula x701 = x702.and(x707);
        Formula x686 = x687.or(x701);
        Formula x679 = x686.forAll(x680);
        Formula x673 = x674.and(x679);
        Formula x660 = x673.forAll(x661);
        Formula x605 = x606.and(x660);
        Formula x365 = x366.and(x605);
        Formula x358 = x365.forSome(x359);
        Formula x351 = x358.forSome(x352);
        Formula x342 = x351.forSome(x343);
        Formula x332 = x342.forSome(x333);
        Formula x322 = x332.forSome(x323);
        Formula x312 = x322.forSome(x313);
        Formula x267 = x312.forSome(x268);
        Variable x712 = Variable.unary("checkOneSolvable3ToNinjaWheel_n1");
        Expression x714 = x8.union(x9);
        Expression x715 = x9.join(x12);
        Expression x713 = x714.union(x715);
        Decls x711 = x712.oneOf(x713);
        Variable x718 = Variable.unary("checkOneSolvable3ToNinjaWheel_n2");
        Expression x721 = x8.union(x9);
        Expression x722 = x9.join(x12);
        Expression x720 = x721.union(x722);
        Expression x719 = x720.difference(x712);
        Decls x717 = x718.oneOf(x719);
        Variable x725 = Variable.unary("checkOneSolvable3ToNinjaWheel_n3");
        Expression x728 = x8.union(x9);
        Expression x729 = x9.join(x12);
        Expression x727 = x728.union(x729);
        Expression x730 = x712.union(x718);
        Expression x726 = x727.difference(x730);
        Decls x724 = x725.oneOf(x726);
        Variable x733 = Variable.unary("DW2E1_p1");
        Expression x737 = x712.join(x10);
        Expression x736 = x737.join(x6);
        Expression x735 = x736.join(x6);
        Expression x742 = x712.join(x10);
        Expression x741 = x742.join(x6);
        Expression x740 = x741.join(x6);
        Expression x745 = x12.transpose();
        Expression x744 = x745.closure();
        Expression x743 = x740.join(x744);
        Expression x739 = x740.difference(x743);
        Expression x738 = x739.join(x12);
        Expression x734 = x735.union(x738);
        Decls x732 = x733.oneOf(x734);
        Variable x748 = Variable.unary("DW2E1_p1h");
        Variable x751 = Variable.unary("DW2E1_i");
        Decls x750 = x751.oneOf(x6);
        Expression x755 = x12.transpose();
        Expression x754 = x755.closure();
        Expression x753 = x733.join(x754);
        Formula x752 = x751.in(x753);
        Expression x749 = x752.comprehension(x750);
        Decls x747 = x748.oneOf(x749);
        Variable x758 = Variable.unary("DW2E1_p2");
        Expression x762 = x718.join(x10);
        Expression x761 = x762.join(x6);
        Expression x760 = x761.join(x6);
        Expression x767 = x718.join(x10);
        Expression x766 = x767.join(x6);
        Expression x765 = x766.join(x6);
        Expression x770 = x12.transpose();
        Expression x769 = x770.closure();
        Expression x768 = x765.join(x769);
        Expression x764 = x765.difference(x768);
        Expression x763 = x764.join(x12);
        Expression x759 = x760.union(x763);
        Decls x757 = x758.oneOf(x759);
        Variable x773 = Variable.unary("DW2E1_p2h");
        Variable x776 = Variable.unary("DW2E1_i");
        Decls x775 = x776.oneOf(x6);
        Expression x780 = x12.transpose();
        Expression x779 = x780.closure();
        Expression x778 = x758.join(x779);
        Formula x777 = x776.in(x778);
        Expression x774 = x777.comprehension(x775);
        Decls x772 = x773.oneOf(x774);
        Variable x783 = Variable.unary("DW2E1_p3");
        Expression x787 = x725.join(x10);
        Expression x786 = x787.join(x6);
        Expression x785 = x786.join(x6);
        Expression x792 = x725.join(x10);
        Expression x791 = x792.join(x6);
        Expression x790 = x791.join(x6);
        Expression x795 = x12.transpose();
        Expression x794 = x795.closure();
        Expression x793 = x790.join(x794);
        Expression x789 = x790.difference(x793);
        Expression x788 = x789.join(x12);
        Expression x784 = x785.union(x788);
        Decls x782 = x783.oneOf(x784);
        Variable x798 = Variable.unary("DW2E1_pa2h");
        Expression x800 = x9.union(x8);
        Expression x801 = x9.join(x12);
        Expression x799 = x800.union(x801);
        Decls x797 = x798.oneOf(x799);
        Variable x804 = Variable.unary("DW2E1_pa2l");
        Expression x807 = x9.union(x8);
        Expression x808 = x9.join(x12);
        Expression x806 = x807.union(x808);
        Expression x805 = x806.difference(x798);
        Decls x803 = x804.oneOf(x805);
        Expression x812 = x725.product(x783);
        Variable x816 = Variable.unary("ValidBest_node");
        Decls x815 = x816.oneOf(x6);
        Variable x818 = Variable.unary("ValidBest_pref");
        Decls x817 = x818.oneOf(x6);
        Decls x814 = x815.and(x817);
        Variable x825 = Variable.unary("ValidChoices2_n");
        Decls x824 = x825.oneOf(x6);
        Variable x827 = Variable.unary("ValidChoices2_p");
        Decls x826 = x827.oneOf(x6);
        Decls x823 = x824.and(x826);
        Expression x833 = x825.join(x10);
        Expression x832 = x833.join(x6);
        Expression x831 = x832.join(x6);
        Expression x838 = x825.join(x10);
        Expression x837 = x838.join(x6);
        Expression x836 = x837.join(x6);
        Expression x841 = x12.transpose();
        Expression x840 = x841.closure();
        Expression x839 = x836.join(x840);
        Expression x835 = x836.difference(x839);
        Expression x834 = x835.join(x12);
        Expression x830 = x831.union(x834);
        Formula x829 = x827.in(x830);
        Expression x847 = x825.join(x10);
        Expression x846 = x847.join(x6);
        Expression x845 = x846.join(x6);
        Formula x844 = x827.in(x845);
        Formula x843 = x844.not();
        Expression x853 = x825.join(x10);
        Expression x852 = x827.join(x853);
        Expression x851 = x9.join(x852);
        Formula x850 = x851.some();
        Formula x849 = x850.not();
        Variable x856 = Variable.unary("ValidPathChoice2_p");
        Expression x861 = x712.product(x733);
        Expression x862 = x718.product(x758);
        Expression x860 = x861.union(x862);
        Expression x864 = x712.product(x748);
        Expression x865 = x718.product(x773);
        Expression x863 = x864.union(x865);
        Expression x859 = x860.union(x863);
        Expression x858 = x812.union(x859);
        Expression x857 = x851.join(x858);
        Decls x855 = x856.oneOf(x857);
        Expression x872 = x825.join(x10);
        Expression x871 = x872.join(x6);
        Expression x870 = x871.join(x6);
        Formula x869 = x827.in(x870);
        Formula x868 = x869.not();
        Formula x867 = x868.not();
        Expression x876 = x825.join(x10);
        Expression x875 = x827.join(x876);
        Expression x874 = x12.join(x875);
        Expression x878 = x851.join(x10);
        Expression x877 = x856.join(x878);
        Formula x873 = x874.eq(x877);
        Formula x866 = x867.and(x873);
        Formula x854 = x866.forSome(x855);
        Formula x848 = x849.or(x854);
        Formula x842 = x843.or(x848);
        Formula x828 = x829.and(x842);
        Expression x822 = x828.comprehension(x823);
        Expression x821 = x816.join(x822);
        Formula x820 = x818.in(x821);
        Variable x881 = Variable.unary("ValidBest_j");
        Expression x882 = x816.join(x822);
        Decls x880 = x881.oneOf(x882);
        Expression x887 = x12.transpose();
        Expression x886 = x887.closure();
        Expression x885 = x818.join(x886);
        Formula x884 = x881.in(x885);
        Formula x883 = x884.not();
        Formula x879 = x883.forAll(x880);
        Formula x819 = x820.and(x879);
        Expression x813 = x819.comprehension(x814);
        Formula x811 = x812.in(x813);
        Variable x891 = Variable.unary("DW2E_n");
        Decls x890 = x891.oneOf(x725);
        Expression x896 = x891.join(x812);
        Expression x897 = x891.join(x10);
        Expression x895 = x896.join(x897);
        Expression x894 = x6.join(x895);
        Expression x898 = x44.difference(x725);
        Expression x893 = x894.intersection(x898);
        Formula x892 = x893.no();
        Formula x889 = x892.forAll(x890);
        Variable x903 = Variable.unary("goesThruItsOwnParity_pref2");
        Expression x909 = x718.join(x10);
        Expression x908 = x773.join(x909);
        Expression x907 = x9.join(x908);
        Expression x906 = x907.join(x10);
        Expression x905 = x906.join(x6);
        Expression x904 = x905.join(x6);
        Decls x902 = x903.oneOf(x904);
        Expression x914 = x718.join(x10);
        Expression x913 = x773.join(x914);
        Expression x912 = x12.join(x913);
        Expression x916 = x907.join(x10);
        Expression x915 = x903.join(x916);
        Formula x911 = x912.eq(x915);
        Expression x923 = x733.product(x9);
        Expression x922 = x712.product(x923);
        Expression x925 = x758.product(x804);
        Expression x924 = x718.product(x925);
        Expression x921 = x922.union(x924);
        Expression x928 = x748.product(x8);
        Expression x927 = x712.product(x928);
        Expression x930 = x773.product(x798);
        Expression x929 = x718.product(x930);
        Expression x926 = x927.union(x929);
        Expression x920 = x921.union(x926);
        Expression x919 = x718.join(x920);
        Expression x918 = x773.join(x919);
        Expression x932 = x907.join(x920);
        Expression x931 = x903.join(x932);
        Formula x917 = x918.eq(x931);
        Formula x910 = x911.and(x917);
        Formula x901 = x910.forSome(x902);
        Expression x939 = x718.join(x10);
        Expression x938 = x939.join(x6);
        Expression x937 = x938.join(x6);
        Formula x936 = x758.in(x937);
        Formula x935 = x936.not();
        Expression x944 = x718.join(x10);
        Expression x943 = x758.join(x944);
        Expression x942 = x9.join(x943);
        Formula x941 = x942.no();
        Variable x947 = Variable.unary("isLeg_pref2");
        Expression x948 = x942.join(x812);
        Decls x946 = x947.oneOf(x948);
        Expression x955 = x718.join(x10);
        Expression x954 = x955.join(x6);
        Expression x953 = x954.join(x6);
        Formula x952 = x758.in(x953);
        Formula x951 = x952.not();
        Formula x950 = x951.not();
        Expression x959 = x718.join(x10);
        Expression x958 = x758.join(x959);
        Expression x957 = x12.join(x958);
        Expression x961 = x942.join(x10);
        Expression x960 = x947.join(x961);
        Formula x956 = x957.eq(x960);
        Formula x949 = x950.and(x956);
        Formula x945 = x949.forSome(x946);
        Formula x940 = x941.or(x945);
        Formula x934 = x935.or(x940);
        Variable x964 = Variable.unary("goesThruItsOwnParity_pref2");
        Expression x970 = x718.join(x10);
        Expression x969 = x758.join(x970);
        Expression x968 = x9.join(x969);
        Expression x967 = x968.join(x10);
        Expression x966 = x967.join(x6);
        Expression x965 = x966.join(x6);
        Decls x963 = x964.oneOf(x965);
        Expression x975 = x718.join(x10);
        Expression x974 = x758.join(x975);
        Expression x973 = x12.join(x974);
        Expression x977 = x968.join(x10);
        Expression x976 = x964.join(x977);
        Formula x972 = x973.eq(x976);
        Expression x980 = x718.join(x920);
        Expression x979 = x758.join(x980);
        Expression x982 = x968.join(x920);
        Expression x981 = x964.join(x982);
        Formula x978 = x979.eq(x981);
        Formula x971 = x972.and(x978);
        Formula x962 = x971.forSome(x963);
        Formula x933 = x934.or(x962);
        Formula x900 = x901.and(x933);
        Variable x985 = Variable.unary("DWNodeCheck_k");
        Variable x988 = Variable.unary("DWNodeCheck_i");
        Decls x987 = x988.oneOf(x6);
        Expression x993 = x12.transpose();
        Expression x992 = x993.closure();
        Expression x991 = x758.join(x992);
        Formula x990 = x988.in(x991);
        Formula x995 = x988.eq(x773);
        Formula x994 = x995.not();
        Formula x989 = x990.and(x994);
        Expression x986 = x989.comprehension(x987);
        Decls x984 = x985.oneOf(x986);
        Expression x1002 = x718.join(x10);
        Expression x1001 = x985.join(x1002);
        Expression x1000 = x9.join(x1001);
        Formula x999 = x1000.no();
        Variable x1005 = Variable.unary("isLeg_pref2");
        Expression x1006 = x1000.join(x812);
        Decls x1004 = x1005.oneOf(x1006);
        Expression x1013 = x718.join(x10);
        Expression x1012 = x1013.join(x6);
        Expression x1011 = x1012.join(x6);
        Formula x1010 = x985.in(x1011);
        Formula x1009 = x1010.not();
        Formula x1008 = x1009.not();
        Expression x1017 = x718.join(x10);
        Expression x1016 = x985.join(x1017);
        Expression x1015 = x12.join(x1016);
        Expression x1019 = x1000.join(x10);
        Expression x1018 = x1005.join(x1019);
        Formula x1014 = x1015.eq(x1018);
        Formula x1007 = x1008.and(x1014);
        Formula x1003 = x1007.forSome(x1004);
        Formula x998 = x999.or(x1003);
        Formula x997 = x998.not();
        Variable x1022 = Variable.unary("DWNodeCheck_first_hop_k_pref");
        Expression x1026 = x718.join(x10);
        Expression x1025 = x985.join(x1026);
        Expression x1024 = x9.join(x1025);
        Expression x1023 = x1024.join(x859);
        Decls x1021 = x1022.oneOf(x1023);
        Expression x1035 = x718.join(x10);
        Expression x1034 = x1035.join(x6);
        Expression x1033 = x1034.join(x6);
        Formula x1032 = x985.in(x1033);
        Formula x1031 = x1032.not();
        Formula x1030 = x1031.not();
        Expression x1039 = x718.join(x10);
        Expression x1038 = x985.join(x1039);
        Expression x1037 = x12.join(x1038);
        Expression x1041 = x1024.join(x10);
        Expression x1040 = x1022.join(x1041);
        Formula x1036 = x1037.eq(x1040);
        Formula x1029 = x1030.and(x1036);
        Formula x1028 = x1029.not();
        Expression x1045 = x1024.join(x920);
        Expression x1044 = x1022.join(x1045);
        Expression x1047 = x718.join(x920);
        Expression x1046 = x773.join(x1047);
        Formula x1043 = x1044.eq(x1046);
        Expression x1050 = x12.closure();
        Expression x1049 = x773.join(x1050);
        Formula x1048 = x985.in(x1049);
        Formula x1042 = x1043.and(x1048);
        Formula x1027 = x1028.or(x1042);
        Formula x1020 = x1027.forAll(x1021);
        Formula x996 = x997.and(x1020);
        Formula x983 = x996.forAll(x984);
        Formula x899 = x900.and(x983);
        Formula x888 = x889.and(x899);
        Formula x810 = x811.and(x888);
        Variable x1055 = Variable.unary("goesThruItsOwnParity_pref2");
        Expression x1061 = x712.join(x10);
        Expression x1060 = x748.join(x1061);
        Expression x1059 = x9.join(x1060);
        Expression x1058 = x1059.join(x10);
        Expression x1057 = x1058.join(x6);
        Expression x1056 = x1057.join(x6);
        Decls x1054 = x1055.oneOf(x1056);
        Expression x1066 = x712.join(x10);
        Expression x1065 = x748.join(x1066);
        Expression x1064 = x12.join(x1065);
        Expression x1068 = x1059.join(x10);
        Expression x1067 = x1055.join(x1068);
        Formula x1063 = x1064.eq(x1067);
        Expression x1071 = x712.join(x920);
        Expression x1070 = x748.join(x1071);
        Expression x1073 = x1059.join(x920);
        Expression x1072 = x1055.join(x1073);
        Formula x1069 = x1070.eq(x1072);
        Formula x1062 = x1063.and(x1069);
        Formula x1053 = x1062.forSome(x1054);
        Expression x1080 = x712.join(x10);
        Expression x1079 = x1080.join(x6);
        Expression x1078 = x1079.join(x6);
        Formula x1077 = x733.in(x1078);
        Formula x1076 = x1077.not();
        Expression x1085 = x712.join(x10);
        Expression x1084 = x733.join(x1085);
        Expression x1083 = x9.join(x1084);
        Formula x1082 = x1083.no();
        Variable x1088 = Variable.unary("isLeg_pref2");
        Expression x1089 = x1083.join(x812);
        Decls x1087 = x1088.oneOf(x1089);
        Expression x1096 = x712.join(x10);
        Expression x1095 = x1096.join(x6);
        Expression x1094 = x1095.join(x6);
        Formula x1093 = x733.in(x1094);
        Formula x1092 = x1093.not();
        Formula x1091 = x1092.not();
        Expression x1100 = x712.join(x10);
        Expression x1099 = x733.join(x1100);
        Expression x1098 = x12.join(x1099);
        Expression x1102 = x1083.join(x10);
        Expression x1101 = x1088.join(x1102);
        Formula x1097 = x1098.eq(x1101);
        Formula x1090 = x1091.and(x1097);
        Formula x1086 = x1090.forSome(x1087);
        Formula x1081 = x1082.or(x1086);
        Formula x1075 = x1076.or(x1081);
        Variable x1105 = Variable.unary("goesThruItsOwnParity_pref2");
        Expression x1111 = x712.join(x10);
        Expression x1110 = x733.join(x1111);
        Expression x1109 = x9.join(x1110);
        Expression x1108 = x1109.join(x10);
        Expression x1107 = x1108.join(x6);
        Expression x1106 = x1107.join(x6);
        Decls x1104 = x1105.oneOf(x1106);
        Expression x1116 = x712.join(x10);
        Expression x1115 = x733.join(x1116);
        Expression x1114 = x12.join(x1115);
        Expression x1118 = x1109.join(x10);
        Expression x1117 = x1105.join(x1118);
        Formula x1113 = x1114.eq(x1117);
        Expression x1121 = x712.join(x920);
        Expression x1120 = x733.join(x1121);
        Expression x1123 = x1109.join(x920);
        Expression x1122 = x1105.join(x1123);
        Formula x1119 = x1120.eq(x1122);
        Formula x1112 = x1113.and(x1119);
        Formula x1103 = x1112.forSome(x1104);
        Formula x1074 = x1075.or(x1103);
        Formula x1052 = x1053.and(x1074);
        Variable x1126 = Variable.unary("DWNodeCheck_k");
        Variable x1129 = Variable.unary("DWNodeCheck_i");
        Decls x1128 = x1129.oneOf(x6);
        Expression x1134 = x12.transpose();
        Expression x1133 = x1134.closure();
        Expression x1132 = x733.join(x1133);
        Formula x1131 = x1129.in(x1132);
        Formula x1136 = x1129.eq(x748);
        Formula x1135 = x1136.not();
        Formula x1130 = x1131.and(x1135);
        Expression x1127 = x1130.comprehension(x1128);
        Decls x1125 = x1126.oneOf(x1127);
        Expression x1143 = x712.join(x10);
        Expression x1142 = x1126.join(x1143);
        Expression x1141 = x9.join(x1142);
        Formula x1140 = x1141.no();
        Variable x1146 = Variable.unary("isLeg_pref2");
        Expression x1147 = x1141.join(x812);
        Decls x1145 = x1146.oneOf(x1147);
        Expression x1154 = x712.join(x10);
        Expression x1153 = x1154.join(x6);
        Expression x1152 = x1153.join(x6);
        Formula x1151 = x1126.in(x1152);
        Formula x1150 = x1151.not();
        Formula x1149 = x1150.not();
        Expression x1158 = x712.join(x10);
        Expression x1157 = x1126.join(x1158);
        Expression x1156 = x12.join(x1157);
        Expression x1160 = x1141.join(x10);
        Expression x1159 = x1146.join(x1160);
        Formula x1155 = x1156.eq(x1159);
        Formula x1148 = x1149.and(x1155);
        Formula x1144 = x1148.forSome(x1145);
        Formula x1139 = x1140.or(x1144);
        Formula x1138 = x1139.not();
        Variable x1163 = Variable.unary("DWNodeCheck_first_hop_k_pref");
        Expression x1167 = x712.join(x10);
        Expression x1166 = x1126.join(x1167);
        Expression x1165 = x9.join(x1166);
        Expression x1164 = x1165.join(x859);
        Decls x1162 = x1163.oneOf(x1164);
        Expression x1176 = x712.join(x10);
        Expression x1175 = x1176.join(x6);
        Expression x1174 = x1175.join(x6);
        Formula x1173 = x1126.in(x1174);
        Formula x1172 = x1173.not();
        Formula x1171 = x1172.not();
        Expression x1180 = x712.join(x10);
        Expression x1179 = x1126.join(x1180);
        Expression x1178 = x12.join(x1179);
        Expression x1182 = x1165.join(x10);
        Expression x1181 = x1163.join(x1182);
        Formula x1177 = x1178.eq(x1181);
        Formula x1170 = x1171.and(x1177);
        Formula x1169 = x1170.not();
        Expression x1186 = x1165.join(x920);
        Expression x1185 = x1163.join(x1186);
        Expression x1188 = x712.join(x920);
        Expression x1187 = x748.join(x1188);
        Formula x1184 = x1185.eq(x1187);
        Expression x1191 = x12.closure();
        Expression x1190 = x748.join(x1191);
        Formula x1189 = x1126.in(x1190);
        Formula x1183 = x1184.and(x1189);
        Formula x1168 = x1169.or(x1183);
        Formula x1161 = x1168.forAll(x1162);
        Formula x1137 = x1138.and(x1161);
        Formula x1124 = x1137.forAll(x1125);
        Formula x1051 = x1052.and(x1124);
        Formula x809 = x810.and(x1051);
        Formula x802 = x809.forSome(x803);
        Formula x796 = x802.forSome(x797);
        Formula x781 = x796.forSome(x782);
        Formula x771 = x781.forSome(x772);
        Formula x756 = x771.forSome(x757);
        Formula x746 = x756.forSome(x747);
        Formula x731 = x746.forSome(x732);
        Formula x723 = x731.forSome(x724);
        Formula x716 = x723.forSome(x717);
        Formula x710 = x716.forSome(x711);
        Formula x266 = x267.or(x710);
        Formula x265 = x266.not();
        Formula x142 = x143.iff(x265);
        Formula x137 = x138.or(x142);
        Formula x136 = x137.not();
        Formula x1192 = x0.eq(x0);
        Formula x1193 = x1.eq(x1);
        Formula x1194 = x2.eq(x2);
        Formula x1195 = x3.eq(x3);
        Formula x1196 = x4.eq(x4);
        Formula x1197 = x5.eq(x5);
        Formula x1198 = x6.eq(x6);
        Formula x1199 = x7.eq(x7);
        Formula x1200 = x8.eq(x8);
        Formula x1201 = x9.eq(x9);
        Formula x1202 = x10.eq(x10);
        Formula x1203 = x11.eq(x11);
        Formula x1204 = x12.eq(x12);
        Formula x1205 = x13.eq(x13);
        
        Formula[] fs = new Formula[] {x15, x16, x17, x18, x19, x26, x31, x34,
                x38, x39, x40, x42, x48, x57, x69, x82, x87, x109, x130, x136, x1192, x1193, x1194,
                x1195, x1196, x1197, x1198, x1199, x1200, x1201, x1202, x1203, x1204, x1205};
        
        String[] fsn = new String[] {"x15", "x16", "x17", "x18", "x19", "x26", "x31", "x34",
                "x38", "x39", "x40", "x42", "x48", "x57", "x69", "x82", "x87", "x109", "x130", "x136", "x1192", "x1193", "x1194",
                "x1195", "x1196", "x1197", "x1198", "x1199", "x1200", "x1201", "x1202", "x1203", "x1204", "x1205"};
        
        Formula x14 = Formula.compose(FormulaOperator.AND, fs);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSatExternal);
        solver.options().setBitwidth(4);
        solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        solver.options().setNoOverflow(false);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x14, bounds);
        System.out.println(sol.toString());
        System.out.println("Evaluating...");
        Instance instance = sol.instance();
        
        IOUtils.writeQuitely(new XStream().toXML(instance), new File("/tmp/kk-inst.xml"));
        
        Evaluator ev = new Evaluator(instance, solver.options());
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fsn[i] + " =\n" + PrettyPrinter.print(fs[i], 2));
        }
        System.out.println("\n===========================\n");
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fsn[i] + " = " + ev.evaluate(fs[i]));
        }
        System.out.println("x14 = " + ev.evaluate(x14));
    }
}
