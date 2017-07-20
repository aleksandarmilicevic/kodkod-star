package examples.hol;

import java.util.LinkedList;
import java.util.List;

import kodkod.ast.Formula;
import kodkod.ast.IntConstant;
import kodkod.ast.IntExpression;
import kodkod.ast.Relation;
import kodkod.ast.Variable;
import kodkod.engine.HOLSolver;
import kodkod.engine.Solution;
import kodkod.engine.config.Options;
import kodkod.engine.satlab.SATFactory;
import kodkod.instance.Bounds;
import kodkod.instance.TupleFactory;
import kodkod.instance.Universe;

public class Simple {
    private Relation Node;

    private void go() {
        createRelations();
        Bounds b = getBounds();
        Formula f = getFormula();
        System.out.println(f);
        //        System.out.println(b);
        Options opt = new Options();
        opt.setSkolemDepth(30);
        opt.setSolver(SATFactory.MiniSat);
        opt.setAllowHOL(true);
        HOLSolver s = HOLSolver.solver(opt);
        Solution sol = s.solve(f, b);
        System.out.println(sol);
    }

    private void createRelations() {
        Node = Relation.unary("Node");
    }

    private Universe getUniverse() {
        List<Object> atoms = new LinkedList<Object>();
        atoms.add("Node1");
        atoms.add("Node2");
        atoms.add("Node3");
        atoms.add(-1);
        atoms.add(0);
        atoms.add(1);
        atoms.add(2);
        atoms.add(3);
        return new Universe(atoms);
    }

    private Bounds getBounds() {
        Universe u = getUniverse();
        TupleFactory f = u.factory();
        Bounds b = new Bounds(u);
        b.bound(Node, f.setOf("Node1", "Node2", "Node3"));

        b.boundExactly(-1, f.setOf(-1));
        b.boundExactly(0, f.setOf(0));
        b.boundExactly(1, f.setOf(1));
        b.boundExactly(2, f.setOf(2));
        b.boundExactly(3, f.setOf(3));

        return b;
    }

    private Formula getFormula() {
        Variable s = Variable.unary("s");
        IntExpression si = s.sum();
        Variable ns = Variable.unary("ns");
        Formula cnd = si.gt(IntConstant.constant(0));
        return cnd.and(ns.count().gt(si).forAll(ns.setOf(Node))).forSome(s.oneOf(Relation.INTS));
    }

    public static void main(String[] args) {
        new Simple().go();
    }
}
