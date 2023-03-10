package com.seaSaltedToaster.simpleEngine.utilities;

import java.nio.FloatBuffer;

//Credit to LWJGL 2 Util
public class Vector3f {
	
	public float x, y, z;
	
	public Vector3f() {
		super();
	}
	
	public Vector3f(Vector3f src) {
		set(src);
	}
	
	public Vector3f(Vector4f src) {
		set(src.x, src.y, src.z);
	}

    public Vector3f copy() {
    	return new Vector3f(x, y, z);
    }
    
    public boolean equals(Vector3f v2) {
    	return (x == v2.x && y == v2.y && z == v2.z);
    }
    
    public boolean equals(Vector3f v2, float y) {
    	return (x == v2.x && z == v2.z);
    }
	
	public Vector3f(float x, float y, float z) {
		set(x, y, z);
	}
	
	public Vector3f(float x) {
		set(x, x, x);
	}
	
	public Vector3f(double x, double y, double z) {
		this.x = (float) x;
		this.y = (float) y;
		this.z = (float) z;	
	}

	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3f set(Vector3f src) {
		x = src.getX();
		y = src.getY();
		z = src.getZ();
		return this;
	}
	
	public float lengthSquared() {
		return x * x + y * y + z * z;
	}
	
	public Vector3f translate(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}
	
	public static Vector3f add(Vector3f left, Vector3f right, Vector3f dest) {
		if (dest == null)
			return new Vector3f(left.x + right.x, left.y + right.y, left.z + right.z);
		else {
			dest.set(left.x + right.x, left.y + right.y, left.z + right.z);
			return dest;
		}
	}
	
	public static Vector3f sub(Vector3f left, Vector3f right, Vector3f dest) {
		if (dest == null)
			return new Vector3f(left.x - right.x, left.y - right.y, left.z - right.z);
		else {
			dest.set(left.x - right.x, left.y - right.y, left.z - right.z);
			return dest;
		}
	}
	
	public static Vector3f cross(
			Vector3f left,
			Vector3f right,
			Vector3f dest)
	{

		if (dest == null)
			dest = new Vector3f();

		dest.set(
				left.y * right.z - left.z * right.y,
				right.x * left.z - right.z * left.x,
				left.x * right.y - left.y * right.x
				);

		return dest;
	}
	
	public Vector3f negate() {
		x = -x;
		y = -y;
		z = -z;
		return this;
	}
	
	public Vector3f negate(Vector3f dest) {
		if (dest == null)
			dest = new Vector3f();
		dest.x = -x;
		dest.y = -y;
		dest.z = -z;
		return dest;
	}
	
	public Vector3f normalise(Vector3f dest) {
		float l = length();

		if (dest == null)
			dest = new Vector3f(x / l, y / l, z / l);
		else
			dest.set(x / l, y / l, z / l);

		return dest;
	}
	
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }
    
    public Vector3f normalize() {
        float length = length();
        return divide(length);
    }
    
    public Vector3f add(Vector3f other) {
        float x = this.x + other.x;
        float y = this.y + other.y;
        float z = this.z + other.z;
        return new Vector3f(x, y, z);
    }
    
    public Vector3f subtract(Vector3f other) {
        return this.add(other.negate());
    }
        
    public Vector3f divide(float scalar) {
        return scale(1f / scalar);
    }
    
    public float dot(Vector3f other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }
    
    public Vector3f cross(Vector3f other) {
        float x = this.y * other.z - this.z * other.y;
        float y = this.z * other.x - this.x * other.z;
        float z = this.x * other.y - this.y * other.x;
        return new Vector3f(x, y, z);
    }
	
	public static float dot(Vector3f left, Vector3f right) {
		return left.x * right.x + left.y * right.y + left.z * right.z;
	}
	
	public static float angle(Vector3f a, Vector3f b) {
		float dls = dot(a, b) / (a.length() * b.length());
		if (dls < -1f)
			dls = -1f;
		else if (dls > 1.0f)
			dls = 1.0f;
		return (float)Math.acos(dls);
	}
	
	public Vector3f load(FloatBuffer buf) {
		x = buf.get();
		y = buf.get();
		z = buf.get();
		return this;
	}
	
	public Vector3f scale(float scale) {

		x *= scale;
		y *= scale;
		z *= scale;

		return this;

	}
	
	public Vector3f store(FloatBuffer buf) {

		buf.put(x);
		buf.put(y);
		buf.put(z);

		return this;
	}
	
	public String toString() {
		return x + ", " + y + ", " + z;
	}
	
	public final float getX() {
		return x;
	}
	
	public final float getY() {
		return y;
	}
	
	public final void setX(float x) {
		this.x = x;
	}
	
	public final void setY(float y) {
		this.y = y;
	}
	
	public void setZ(float z) {
		this.z = z;
	}
	
	public float getZ() {
		return z;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Vector3f other = (Vector3f)obj;
		
		if (x == other.x && y == other.y && z == other.z) return true;
		
		return false;
	}

	public Vector3f round() {
		return new Vector3f(Math.round(x), Math.round(y), Math.round(z));
	}

	public void increase(float dx, int dy, float dz) {
		this.x += dx;
		this.y += dy;
		this.z += dz;
	}

	public boolean isEmpty() {
		return (x == 0 && y == 0 && z ==0);
	}
	
}
